package com.natsuyami.inventory.validation;

import com.natsuyami.inventory.dto.ShopDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShopValidation {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopValidation.class);

    protected static ShopValidation instance;

    protected ShopValidation() {}

    public static ShopValidation getInstance() {
        if (instance == null) {
            instance = new ShopValidation();
        }

        return instance;
    }

    public void validate(ShopDto shopDto) {
        LOGGER.info("Validating shopDto using ShopValidation instance");
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
