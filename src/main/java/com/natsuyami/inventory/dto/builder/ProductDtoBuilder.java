package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.dto.ProductDto;
import com.natsuyami.inventory.model.Product;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProductDtoBuilder {

    protected static ProductDtoBuilder instance;

    protected ProductDtoBuilder() {}

    public static ProductDtoBuilder getInstance() {
        if (instance == null) {
            instance = new ProductDtoBuilder();
        }

        return instance;
    }

    public ProductDto build(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);

        return productDto;
    }
}
