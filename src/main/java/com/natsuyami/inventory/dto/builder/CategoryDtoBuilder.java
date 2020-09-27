package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.model.ProductCategory;
import org.springframework.beans.BeanUtils;

public class CategoryDtoBuilder {

    protected static CategoryDtoBuilder instance;

    protected CategoryDtoBuilder() {}

    public static CategoryDtoBuilder getInstance() {
        if (instance == null) {
            instance = new CategoryDtoBuilder();
        }

        return instance;
    }

    public CategoryDto build(ProductCategory productCategory) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(productCategory, categoryDto);

        return categoryDto;
    }
}
