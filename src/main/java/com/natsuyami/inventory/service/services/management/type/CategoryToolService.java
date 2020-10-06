package com.natsuyami.inventory.service.services.management.type;

import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.dto.builder.CategoryDtoBuilder;
import com.natsuyami.inventory.model.ProductCategory;
import com.natsuyami.inventory.repository.CategoryRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.validation.CategoryValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryToolService implements ManagementImpl<CategoryDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryToolService.class);

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        LOGGER.info("Initialized CategoryToolService create() method with param={{}}", categoryDto);
        CategoryValidation.getInstance().validate(categoryDto);
        ProductCategory productCategory = new ProductCategory();
        BeanUtils.copyProperties(categoryDto, productCategory);

        LOGGER.info("Saving category category={{}}", productCategory.getCategory());
        productCategory = categoryRepository.save(productCategory);

        return CategoryDtoBuilder.getInstance().build(productCategory);
    }

    @Override
    public CategoryDto update(CategoryDto obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
