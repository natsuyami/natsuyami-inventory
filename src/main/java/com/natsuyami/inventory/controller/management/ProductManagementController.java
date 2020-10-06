package com.natsuyami.inventory.controller.management;

import com.natsuyami.inventory.controller.ProductController;
import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.factory.ProductFactory;
import com.natsuyami.inventory.service.services.type.CategoryService;
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
@RequestMapping(value = "/management/product", produces = "application/json")
public class ProductManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductFactory productService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "create product with or without additional details",
                    notes = "no error formats as of now",
                    response = ProductDetailsDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "category not found/exist"),
            @ApiResponse(code = 400, message = "there is an invalid data")
    })
    @PostMapping
    public Object createOne(@RequestBody ProductDetailsDto productDto) {
        CategoryDto categoryDto = categoryService.getById(productDto.getCategoryId());
        LOGGER.info("Initialized ProductManagementController createOne() method for category={{}} with param={{}}", categoryDto.getCategory(), productDto);
        ProductDetailsDto product = productService.productTools(categoryDto.getCategory()).create(productDto);
        return product;
    }
}
