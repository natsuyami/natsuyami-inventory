package com.natsuyami.inventory.validation.product;

import com.natsuyami.inventory.dto.AddressDto;

public class AddressValidation {

    protected static AddressValidation instance;

    protected AddressValidation() {}

    public static AddressValidation getInstance() {
        if (instance == null) {
            instance = new AddressValidation();
        }

        return instance;
    }

    public void validate(AddressDto addressDto) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
