package com.natsuyami.inventory.controller.management;

import com.natsuyami.inventory.dto.ShopDto;
import com.natsuyami.inventory.service.services.management.ShopToolService;
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
@RequestMapping(value = "/management/shop", produces = "application/json")
public class ShopManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopManagementController.class);

    @Autowired
    private ShopToolService shopToolService;

    @ApiOperation(value = "create shop with address",
                    notes = "no error format as of now",
                    response = ShopDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @PostMapping
    public Object createOne(@RequestBody ShopDto shopDto) {
        LOGGER.info("Initialized ShopManagementController createOne() method with param shopDto={{}}", shopDto);
        return shopToolService.create(shopDto);
    }
}
