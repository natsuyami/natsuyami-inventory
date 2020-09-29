package com.natsuyami.inventory.controller;

import com.natsuyami.inventory.dto.RoleDto;
import com.natsuyami.inventory.service.services.RoleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/role", produces = "application/json")
public class RoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "get role",
            notes = "no error formats as of now",
            response = RoleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @PostMapping
    public Object findById(@PathParam("id") long id) {
        LOGGER.info("Initialized RoleController findById() method with param roleId={{}}", id);
        return roleService.getById(id);
    }
}
