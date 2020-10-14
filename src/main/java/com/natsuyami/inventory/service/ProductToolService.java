package com.natsuyami.inventory.service;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.dto.ProductDto;
import com.natsuyami.inventory.dto.builder.ProductDetailsDtoBuilder;
import com.natsuyami.inventory.model.ProductCategory;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.model.ShopProduct;
import com.natsuyami.inventory.repository.ProductRepository;
import com.natsuyami.inventory.repository.ShopProductRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.services.type.CategoryService;
import com.natsuyami.inventory.service.services.ShopService;
import com.natsuyami.inventory.service.encryption.Encryption;
import com.natsuyami.inventory.validation.product.ProductDetailsValidation;
import com.natsuyami.inventory.validation.product.ProductValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductToolService extends ProductService implements ManagementImpl<ProductDetailsDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductToolService.class);

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopProductRepository shopProductRepository;

    @Autowired
    private Encryption encryption;

    /**
     * create one product with/without details and shop.
     * @param productDetailsDto - product extended with details (product and shopProduct)
     * @return ProductDetailsDto - product with/wthout details created.
     */
    @Override
    public ProductDetailsDto create(ProductDetailsDto productDetailsDto) {
        LOGGER.info("Initialized ProductToolsAbstract create() method with param={{}}", productDetailsDto);
        ProductDetailsDto result = new ProductDetailsDto();
        com.natsuyami.inventory.model.Product product;
        if (productDetailsDto.getId() < 1) {
            product = createProduct(productDetailsDto);
        } else {
            product = findById(productDetailsDto.getId());
        }
        BeanUtils.copyProperties(product, result);

        // when shop id exist then additional details should also be saved, otherwise skip and save only the product
        if (productDetailsDto.getShopId() > 0) {
            LOGGER.info("Process product details with shopId={{}}", productDetailsDto.getShopId());
            result = createProductDetails(productDetailsDto, product);
            result.setShopId(productDetailsDto.getShopId());
        }
        result.setCategoryId(productDetailsDto.getCategoryId());

        return result;
    }

    @Override
    public ProductDetailsDto update(ProductDetailsDto productDetailsDto) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    /**
     * validate product data then save the product
     * @param productDto - product data
     * @return Product - data of saved product
     */
    public com.natsuyami.inventory.model.Product createProduct(ProductDto productDto) {
        LOGGER.info("Initialized ProductToolsAbstract createProduct() method with param={{}}", productDto);
        ProductValidation.getInstance().validate(productDto); // initial validation of product data without any api calls
        ProductCategory category = categoryService.getExistingCategory(productDto.getCategoryId());

        com.natsuyami.inventory.model.Product product = new com.natsuyami.inventory.model.Product();
        BeanUtils.copyProperties(productDto, product);
        product.setProductCategory(category);
        product.setCreatedBy(encryption.jwtConverter());

        LOGGER.info("Saving product productName={{}}", product.getProductName());
        product = productRepository.save(product);

        return product;
    }

    /**
     * validate product additional details and find assign shop for the product then save the product
     * @param productDetailsDto - product data with additional info
     * @return ProductDetailsDto - data of saved product with details
     */
    private ProductDetailsDto createProductDetails(ProductDetailsDto productDetailsDto, com.natsuyami.inventory.model.Product product) {
        LOGGER.info("Initialized ProductToolsAbstract createProductDetails() method with param={{}} and productId={{}}", productDetailsDto, product.getId());
        ProductDetailsValidation.getInstance().validate(productDetailsDto); // initial validation of additional details without any api calls
        ShopProduct shopProduct = new ShopProduct();
        BeanUtils.copyProperties(productDetailsDto, shopProduct);

        Shop shop = shopService.findById(productDetailsDto.getShopId()); // find the shop assigned to the product

        shopProduct.setShop(shop);
        shopProduct.setProduct(product);

        LOGGER.info("Saving productDetails productName={{}}", product.getProductName());
        shopProduct = shopProductRepository.save(shopProduct);

        return ProductDetailsDtoBuilder.getInstance().build(shopProduct, product);
    }
}
