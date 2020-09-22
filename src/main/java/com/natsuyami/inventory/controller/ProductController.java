package com.natsuyami.inventory.controller;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.factory.ProductFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductController {

    @Autowired
    ProductFactory productService;

    public Object findOne(long id) {
        return null;
    }

    public Object getAll() {
        return "";
    }

    public Object createProduct(ProductDetailsDto productDto, String category) {
        ProductDetailsDto product = productService.getProduct(category).create(productDto);
        return product;
    }

}
