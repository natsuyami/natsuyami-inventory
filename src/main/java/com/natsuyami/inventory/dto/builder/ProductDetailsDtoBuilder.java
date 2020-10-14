package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.model.Product;
import com.natsuyami.inventory.model.ProductCategory;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.model.ShopProduct;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.parameters.P;

import java.io.Serializable;

public class ProductDetailsDtoBuilder extends ProductDtoBuilder {

    private static ProductDetailsDtoBuilder instance;

    private ProductDetailsDtoBuilder() {}

    public static ProductDetailsDtoBuilder getInstance() {
        if (instance == null) {
            instance = new ProductDetailsDtoBuilder();
        }

        return instance;
    }

    public ProductDetailsDto build(ShopProduct shopProduct, Product product) {
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        BeanUtils.copyProperties(shopProduct, productDetailsDto);
        BeanUtils.copyProperties(product, productDetailsDto);

        if (shopProduct.getShop() != null) {
            productDetailsDto.setShopId(shopProduct.getShop().getId());
            productDetailsDto.setShopName(shopProduct.getShop().getShopName());
        }

        if (product.getProductCategory() != null) {
            productDetailsDto.setCategoryId(product.getProductCategory().getId());
            productDetailsDto.setCategory(product.getProductCategory().getCategory());
        }

        return productDetailsDto;
    }

    public ProductDetailsDto build(ShopProduct shopProduct, Shop shop, ProductCategory category, Product product) {
        ProductDetailsDto productDetailsDto = new ProductDetailsDto();
        BeanUtils.copyProperties(shopProduct, productDetailsDto);
        BeanUtils.copyProperties(shop, productDetailsDto);
        BeanUtils.copyProperties(product, productDetailsDto);
        BeanUtils.copyProperties(category, productDetailsDto);

        return productDetailsDto;
    }
}
