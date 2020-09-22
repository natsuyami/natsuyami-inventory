package com.natsuyami.inventory.controller.management;

import com.natsuyami.inventory.controller.ProductController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product-management", produces = "application/json")
public class ProductManagementController extends ProductController {

    public Object createOne() {
        return "";
    }

}
