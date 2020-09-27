package com.natsuyami.inventory.validation.product;

import com.natsuyami.inventory.dto.ProductDto;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductValidation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductValidation.class);

    protected static ProductValidation instance;

    protected ProductValidation() {}

    public static ProductValidation getInstance() {
        if (instance == null) {
            instance = new ProductValidation();
        }

        return instance;
    }

    public void validate(ProductDto productDto) {
        LOGGER.info("Validating productDto using ProductValidation instance");
        try {
            validateProductName(productDto.getProductName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateProductName(String name) throws Exception {
        LOGGER.info("Validating name={{}} using validateProductName", name);
        if (StringUtils.isBlank(name)) {
            throw new Exception("Product Name is blank");
        }

        if (name.length() > 255 || name.length() < 1) {
            throw new Exception("Product Name size invalid");
        }
    }
}
