package com.natsuyami.inventory.controller;

import com.natsuyami.inventory.dto.AccountDto;
import com.natsuyami.inventory.service.services.management.AccountToolService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account", produces = "application/json")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountToolService accountToolService;

    @ApiOperation(value = "create account",
            notes = "no error formats as of now",
            response = AccountDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @PostMapping
    public Object createOne(@RequestBody AccountDto accountDto) {
        LOGGER.info("Initialized AccountController createOne() method with param accountDto={{}}", accountDto);
        return accountToolService.create(accountDto);
    }
}
