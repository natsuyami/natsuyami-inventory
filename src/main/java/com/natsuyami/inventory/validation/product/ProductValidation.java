package com.natsuyami.inventory.validation.product;

import com.natsuyami.inventory.dto.ProductDto;
import io.micrometer.core.instrument.util.StringUtils;

public class ProductValidation {
    protected static ProductValidation instance;

    protected ProductValidation() {}

    public static ProductValidation getInstance() {
        if (instance == null) {
            instance = new ProductValidation();
        }

        return instance;
    }

    public void validate(ProductDto productDto) {
        try {
            validateProductName(productDto.getProductName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateProductName(String name) throws Exception {
        if (StringUtils.isBlank(name)) {
            throw new Exception("Product Name is blank");
        }

        if (name.length() > 255 || name.length() < 1) {
            throw new Exception("Product Name size invalid");
        }
    }
}
