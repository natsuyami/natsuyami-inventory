package com.natsuyami.inventory.controller;

import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.factory.ProductFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product", produces = "application/json")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductFactory productService;

    public Object findOne(long id) {
        return null;
    }

    @ApiOperation(value = "get all products",
            notes = "no error format as of now",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @GetMapping
    public Object getAll() {
        return "Test";
    }

}
