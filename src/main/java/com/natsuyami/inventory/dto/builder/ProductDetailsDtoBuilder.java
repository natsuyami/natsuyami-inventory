package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.model.Product;
import com.natsuyami.inventory.model.ShopProduct;
import org.springframework.beans.BeanUtils;

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

        return productDetailsDto;
    }
}
