package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.AccountDto;
import com.natsuyami.inventory.model.Account;
import com.natsuyami.inventory.model.Role;
import org.springframework.beans.BeanUtils;

public class AccountDtoBuilder {

    protected static AccountDtoBuilder instance;

    protected  AccountDtoBuilder() {}

    public static AccountDtoBuilder getInstance() {
        if (instance == null) {
            instance = new AccountDtoBuilder();
        }

        return instance;
    }

    public AccountDto build(Account account, Role role) {
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        accountDto.setRoleId(role.getId());

        return accountDto;
    }
}
