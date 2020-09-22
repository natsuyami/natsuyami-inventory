package com.natsuyami.inventory.validation.product;

import com.natsuyami.inventory.dto.ShopDto;

public class ShopValidation {

    protected static ShopValidation instance;

    protected ShopValidation() {}

    public static ShopValidation getInstance() {
        if (instance == null) {
            instance = new ShopValidation();
        }

        return instance;
    }

    public void validate(ShopDto shopDto) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
