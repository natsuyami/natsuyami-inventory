package com.natsuyami.inventory.controller.management;

import com.natsuyami.inventory.dto.AddressDto;
import com.natsuyami.inventory.service.services.management.AddressToolService;
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
@RequestMapping(value = "/management/address", produces = "application/json")
public class AddressManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressManagementController.class);

    @Autowired
    private AddressToolService addressToolService;

    @ApiOperation(value = "create address",
                    notes = "no error formats as of now",
                    response = AddressDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "address not found/exist"),
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @PostMapping
    public Object createOne(@RequestBody AddressDto addressDto) {
        LOGGER.info("Initialized AddressManagementController createOne() method with param addressDto={{}}", addressDto);
        return addressToolService.create(addressDto);
    }
}
