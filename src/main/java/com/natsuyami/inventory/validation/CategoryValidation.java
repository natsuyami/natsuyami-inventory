package com.natsuyami.inventory.validation;

import com.natsuyami.inventory.dto.CategoryDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryValidation {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryValidation.class);

    protected static CategoryValidation instance;

    protected CategoryValidation() {}

    public static CategoryValidation getInstance() {
        if (instance == null) {
            instance = new CategoryValidation();
        }

        return instance;
    }

    public void validate(CategoryDto categoryDto) {
        LOGGER.info("Validating categoryDto using CategoryValidation instance");

    }
}
