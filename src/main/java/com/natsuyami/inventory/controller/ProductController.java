package com.natsuyami.inventory.controller;

import com.natsuyami.inventory.dto.ProductDto;
import com.natsuyami.inventory.factory.ProductFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product", produces = "application/json")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductFactory productService;

    @ApiOperation(value = "get all products",
            notes = "no error format as of now",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "there is an invalid data from database")
    })
    @GetMapping("/{category}")
    public Object getAll(@PathVariable("category") String category) {
        LOGGER.info("Initialized ProductController getAll() method for category={{}}", category);
        List<ProductDto> products = productService.getProduct(category).getAll();
        return products;
    }

    @ApiOperation(value = "search a products with the given keyword",
            notes = "no error format as of now",
            response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "there is an invalid data from database")
    })
    @GetMapping("/{category}/{keyword}")
    public Object search(@PathVariable("category") String category, @PathVariable("keyword") String keyword) {
        LOGGER.info("Initialized ProductController search() method for category={{}} with keyword={{}}", category, keyword);
        List<ProductDto> products = productService.getProduct(category).search(keyword);
        return products;
    }
}
