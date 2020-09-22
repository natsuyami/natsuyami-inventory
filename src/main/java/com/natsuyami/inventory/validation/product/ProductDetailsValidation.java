package com.natsuyami.inventory.validation.product;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import io.micrometer.core.instrument.util.StringUtils;

import java.math.BigDecimal;

public class ProductDetailsValidation extends ProductValidation {

    protected static ProductDetailsValidation instance;

    protected  ProductDetailsValidation() {}

    public static ProductDetailsValidation getInstance() {
        if (instance == null) {
            instance = new ProductDetailsValidation();
        }

        return instance;
    }

    public void validate(ProductDetailsDto productDetailsDto) {
        try {
            validateProductName(productDetailsDto.getProductName());
            validateProductPrice(productDetailsDto.getPrice());
            validateProductCurrency(productDetailsDto.getCurrency());
            validateProductQuantity(productDetailsDto.getQuantity());
            validateProductUnit(productDetailsDto.getUnit());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateProductPrice(BigDecimal price) throws Exception {
        if (price.compareTo(BigDecimal.ZERO) < 1) {
            throw new Exception("Price should be higher than 0");
        }
    }

    public void validateProductCurrency(String currency) throws Exception {
        if (StringUtils.isBlank(currency)) {
            throw new Exception("Currency is blank");
        }
    }

    public void validateProductQuantity(BigDecimal quantity) throws Exception {
        if (quantity.compareTo(BigDecimal.ZERO) < 1) {
            throw new Exception("Product quantity is blank");
        }
    }

    public void validateProductUnit(String unit) throws Exception {
        if (StringUtils.isBlank(unit)) {
            throw new Exception("Product unit is blank");
        }
    }
}
