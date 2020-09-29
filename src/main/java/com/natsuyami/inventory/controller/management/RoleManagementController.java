package com.natsuyami.inventory.controller.management;

import com.natsuyami.inventory.dto.RoleDto;
import com.natsuyami.inventory.service.services.management.RoleToolService;
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
@RequestMapping(value = "/management/role", produces = "application/json")
public class RoleManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleManagementController.class);

    @Autowired
    private RoleToolService roleToolService;

    @ApiOperation(value = "create role",
            notes = "no error formats as of now",
            response = RoleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @PostMapping
    public Object createOne(@RequestBody RoleDto roleDto) {
        LOGGER.info("Initialized RoleManagementController createOne() method with param roleDto={{}}", roleDto);
        return roleToolService.create(roleDto);
    }
}
