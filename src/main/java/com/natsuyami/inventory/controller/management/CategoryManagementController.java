package com.natsuyami.inventory.controller.management;

import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.service.services.management.type.CategoryToolService;
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
@RequestMapping(value = "/management/category", produces = "application/json")
public class CategoryManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryManagementController.class);

    @Autowired
    private CategoryToolService categoryToolService;

    @ApiOperation(value = "create category",
            notes = "no error format as of now",
            response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @PostMapping
    public Object createOne(@RequestBody CategoryDto categoryDto) {
        LOGGER.info("Initialized CategoryManagementController createOne() method with param shopDto={{}}", categoryDto);
        return categoryToolService.create(categoryDto);
    }

}
