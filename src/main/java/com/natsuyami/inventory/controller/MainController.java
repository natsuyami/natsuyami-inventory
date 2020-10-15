package com.natsuyami.inventory.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @ApiOperation(value = "test if app running",
            notes = "testing endpoint only",
            response = String.class)
    @GetMapping
    public Object get() {
        LOGGER.info("Initialized MainController createOne() get");
        return "App is Working";
    }
}
