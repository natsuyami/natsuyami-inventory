package com.natsuyami.inventory.validation;

import com.natsuyami.inventory.dto.AccountDto;

public class AccountValidation {

    protected static AccountValidation instance;

    protected AccountValidation() {}

    public static AccountValidation getInstance() {
        if (instance == null) {
            instance = new AccountValidation();
        }

        return instance;
    }

    public void validate(AccountDto accountDto) {

    }
}
