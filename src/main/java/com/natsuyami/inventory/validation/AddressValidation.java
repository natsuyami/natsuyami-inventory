package com.natsuyami.inventory.validation;

import com.natsuyami.inventory.dto.AddressDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressValidation {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressValidation.class);

    protected static AddressValidation instance;

    protected AddressValidation() {}

    public static AddressValidation getInstance() {
        if (instance == null) {
            instance = new AddressValidation();
        }

        return instance;
    }

    public void validate(AddressDto addressDto) {
        LOGGER.info("Validating addressDto using AddressValidation instance");
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
