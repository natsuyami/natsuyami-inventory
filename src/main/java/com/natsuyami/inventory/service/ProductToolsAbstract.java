package com.natsuyami.inventory.service;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.dto.ProductDto;
import com.natsuyami.inventory.dto.builder.ProductDetailsDtoBuilder;
import com.natsuyami.inventory.model.Product;
import com.natsuyami.inventory.model.ProductCategory;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.model.ShopProduct;
import com.natsuyami.inventory.repository.ProductRepository;
import com.natsuyami.inventory.repository.ShopProductRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.services.CategoryService;
import com.natsuyami.inventory.service.services.ShopService;
import com.natsuyami.inventory.validation.product.ProductDetailsValidation;
import com.natsuyami.inventory.validation.product.ProductValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProductToolsAbstract extends ProductDefaultAbstract implements ManagementImpl<ProductDetailsDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductToolsAbstract.class);

    @Autowired
    private ShopService shopService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopProductRepository shopProductRepository;

    /**
     * create one product with/without details
     * @param productDetailsDto - product extended with details (product and shopProduct)
     * @return ProductDetailsDto - product with/wthout details created.
     */
    @Override
    public ProductDetailsDto create(ProductDetailsDto productDetailsDto) {
        LOGGER.info("Initialized ProductToolsAbstract create() method with param={{}}", productDetailsDto);
        ProductDetailsDto result = new ProductDetailsDto();
        Product product = createProduct(productDetailsDto);
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
    public Product createProduct(ProductDto productDto) {
        LOGGER.info("Initialized ProductToolsAbstract createProduct() method with param={{}}", productDto);
        ProductValidation.getInstance().validate(productDto); // initial validation of product data without any api calls
        ProductCategory category = categoryService.getExistingCategory(productDto.getCategoryId());

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setProductCategory(category);

        LOGGER.info("Saving product productName={{}}", product.getProductName());
        product = productRepository.save(product);

        return product;
    }

    /**
     * validate product additional details and find assign shop for the product then save the product
     * @param productDetailsDto - product data with additional info
     * @return ProductDetailsDto - data of saved product with details
     */
    private ProductDetailsDto createProductDetails(ProductDetailsDto productDetailsDto, Product product) {
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
