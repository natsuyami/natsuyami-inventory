package com.natsuyami.inventory.service.management.product;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.dto.ProductDto;
import com.natsuyami.inventory.dto.builder.ProductDetailsDtoBuilder;
import com.natsuyami.inventory.model.Product;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.model.ShopProduct;
import com.natsuyami.inventory.repository.ProductRepository;
import com.natsuyami.inventory.repository.ShopProductRepository;
import com.natsuyami.inventory.service.impl.ProductImpl;
import com.natsuyami.inventory.service.management.ShopService;
import com.natsuyami.inventory.validation.product.ProductDetailsValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService implements ProductImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodService.class);

    @Autowired
    private ShopService shopService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShopProductRepository shopProductRepository;

    @Override
    public List<ProductDetailsDto> getAll() {
        List<ProductDetailsDto> products = new ArrayList<>();
        return products;
    }

    @Override
    public ProductDetailsDto getById(long id) {
        return new ProductDetailsDto();
    }

    @Override
    public ProductDetailsDto search(String keyword) {
        return null;
    }

    /**
     *
     * @param productDetailsDto
     * @return
     */
    @Override
    public ProductDetailsDto create(ProductDetailsDto productDetailsDto) {
        LOGGER.info("Initialized create() method with param={{}}", productDetailsDto);
        ProductDetailsValidation.getInstance().validate(productDetailsDto);
        Product product = createProduct(productDetailsDto);

        if (productDetailsDto.getShopId() > 0) {
            productDetailsDto = createProductDetails(productDetailsDto, product);
        }

        return productDetailsDto;
    }

    @Override
    public ProductDetailsDto update(ProductDetailsDto obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    /**
     *
     * @param productDto
     * @return
     */
    private Product createProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        product = productRepository.save(product);

        return product;
    }

    /**
     *
     * @param productDetailsDto
     * @return
     */
    private ProductDetailsDto createProductDetails(ProductDetailsDto productDetailsDto, Product product) {
        ShopProduct shopProduct = new ShopProduct();
        BeanUtils.copyProperties(productDetailsDto, shopProduct);

        Shop shop = shopService.findbyId(productDetailsDto.getShopId());

        shopProduct.setShop(shop);
        shopProduct.setProduct(product);

        shopProduct = shopProductRepository.save(shopProduct);

        return ProductDetailsDtoBuilder.getInstance().build(shopProduct, product);
    }
}
