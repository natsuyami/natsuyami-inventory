package com.natsuyami.inventory.factory;

import com.natsuyami.inventory.service.impl.ProductImpl;
import com.natsuyami.inventory.service.management.product.FoodService;
import com.natsuyami.inventory.service.management.product.PharmaceuticalService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductFactory {

    /**
     * Factory Design Pattern
     * @param productType
     * @return
     */
    public ProductImpl getProduct(String productType) {
        if (StringUtils.isBlank(productType)) {
            return null;
        }

        if (productType.equalsIgnoreCase("Food")) {
            return new FoodService();
        } else if (productType.equalsIgnoreCase("Pharmaceutical")) {
            return new PharmaceuticalService();
        }

        return null;
    }
}
