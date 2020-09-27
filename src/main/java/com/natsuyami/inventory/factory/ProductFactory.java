package com.natsuyami.inventory.factory;

import com.natsuyami.inventory.service.ProductDefaultAbstract;
import com.natsuyami.inventory.service.ProductToolsAbstract;
import com.natsuyami.inventory.service.services.FoodService;
import com.natsuyami.inventory.service.services.PharmaceuticalService;
import com.natsuyami.inventory.service.services.management.FoodToolService;
import com.natsuyami.inventory.service.services.management.PharmaceuticalToolService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductFactory {

    @Autowired
    private FoodService foodService;

    @Autowired
    private PharmaceuticalService pharmaceuticalService;

    @Autowired
    private FoodToolService foodToolService;

    @Autowired
    private PharmaceuticalToolService pharmaceuticalToolService;

    /**
     * Factory Design Pattern,
     * For default implementation accessible to public
     * Use type of product service base on category submitted
     * @param productType - category
     * @return ProductDefaultAbstract
     */
    public ProductDefaultAbstract getProduct(String productType) {
        if (StringUtils.isBlank(productType)) {
            return null;
        }

        if (productType.equalsIgnoreCase("Food")) {
            return foodService;
        } else if (productType.equalsIgnoreCase("Pharmaceutical")) {
            return pharmaceuticalService;
        }

        return null;
    }

    /**
     * Factory Design Pattern
     * For management implementation not accessible to public
     * Use type of product service base on category submitted
     * @param productType - category
     * @return ProductToolsAbstract
     */
    public ProductToolsAbstract productTools(String productType) {
        if (StringUtils.isBlank(productType)) {
            return null;
        }

        if (productType.equalsIgnoreCase("Food")) {
            return foodToolService;
        } else if (productType.equalsIgnoreCase("Pharmaceutical")) {
            return pharmaceuticalToolService;
        }

        return null;
    }
}
