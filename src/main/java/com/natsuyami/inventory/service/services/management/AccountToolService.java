package com.natsuyami.inventory.service.services.management;

import com.natsuyami.inventory.dto.AccountDto;
import com.natsuyami.inventory.dto.builder.AccountDtoBuilder;
import com.natsuyami.inventory.encryption.Encryption;
import com.natsuyami.inventory.model.Account;
import com.natsuyami.inventory.model.Role;
import com.natsuyami.inventory.repository.AccountRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.services.AccountService;
import com.natsuyami.inventory.service.services.RoleService;
import com.natsuyami.inventory.validation.AccountValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountToolService extends AccountService implements ManagementImpl<AccountDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountToolService.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private AccountRepository accountRepository;

    /**
     * create single account
     * @param accountDto - details of account
     * @return AccountDto - details of the saved account
     */
    @Override
    public AccountDto create(AccountDto accountDto) {
        LOGGER.info("Initialized AccountToolService create() method with param={{}}", accountDto);
        AccountValidation.getInstance().validate(accountDto);
        accountDto.setPassword(Encryption.encoder().encode(accountDto.getPassword()));
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);

        //get role of the account then set to account model
        Role role = roleService.getRoleById(accountDto.getRoleId());
        account.setRole(role);

        LOGGER.info("Saving account username={{}}", account.getUsername());
        account = accountRepository.save(account);

        return AccountDtoBuilder.getInstance().build(account, role);
    }

    @Override
    public AccountDto update(AccountDto obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
