package com.natsuyami.inventory.validation;

import com.natsuyami.inventory.dto.RoleDto;

public class RoleValidation {

    protected static RoleValidation instance;

    protected RoleValidation() {};

    public static RoleValidation getInstance() {
        if (instance == null) {
            instance = new RoleValidation();
        }

        return instance;
    }

    public void validate(RoleDto roleDto) {

    }
}
