package com.natsuyami.inventory.service.services;

import com.natsuyami.inventory.dto.AccountDto;
import com.natsuyami.inventory.service.impl.DefaultImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements DefaultImpl<AccountDto> {
    @Override
    public List<AccountDto> getAll() {
        return null;
    }

    @Override
    public AccountDto getById(long id) {
        return null;
    }

    @Override
    public List<AccountDto> search(String keyword) {
        return null;
    }
}
