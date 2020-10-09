package com.natsuyami.inventory.service.services.type;

import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.dto.builder.CategoryDtoBuilder;
import com.natsuyami.inventory.model.ProductCategory;
import com.natsuyami.inventory.repository.CategoryRepository;
import com.natsuyami.inventory.service.impl.DefaultImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements DefaultImpl<CategoryDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<CategoryDto> getAll(Pageable pageable) {
        return null;
    }

    /**
     * get category via ID
     * @param id - category id
     * @return CategoryDto - catagory data containing the id
     */
    @Override
    public CategoryDto getById(long id) {
        ProductCategory category = getExistingCategory(id);

        return CategoryDtoBuilder.getInstance().build(category);
    }

    @Override
    public List<CategoryDto> search(String search) {
        return null;
    }

    /**
     * get category if exist, null if not.
     * @param id - category id to be get
     * @return ProductCategory - category data containing the id
     */
    public ProductCategory getExistingCategory(long id) {
        Optional<ProductCategory> result = categoryRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
}
