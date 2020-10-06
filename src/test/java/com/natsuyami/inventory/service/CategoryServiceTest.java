package com.natsuyami.inventory.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.model.ProductCategory;
import com.natsuyami.inventory.repository.CategoryRepository;
import com.natsuyami.inventory.service.services.management.type.CategoryToolService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CategoryServiceTest {

    @Autowired
    private CategoryToolService categoryToolService;

    @MockBean
    private CategoryRepository categoryRepository;

    private CategoryDto categoryDto;

    private ProductCategory productCategory;

    @TestConfiguration
    static class CategoryServiceTestConfiguration {
        @Bean
        public CategoryToolService categoryToolService(){
            return new CategoryToolService();
        }
    }

    @Before
    public void initialized() {
        categoryDto = new CategoryDto();
        categoryDto.setCategory("Food");

        productCategory = new ProductCategory();
        BeanUtils.copyProperties(categoryDto, productCategory);
    }

    @Test
    public void successCreateCategory() {
        Mockito.when(categoryRepository.save(Mockito.any())).thenReturn(productCategory);

        CategoryDto result = categoryToolService.create(categoryDto);

        assertThat(result.getId(), equalTo(productCategory.getId()));
    }
}
