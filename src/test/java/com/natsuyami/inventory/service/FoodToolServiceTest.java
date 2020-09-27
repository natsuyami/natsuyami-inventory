package com.natsuyami.inventory.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.natsuyami.inventory.dto.CategoryDto;
import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.model.ProductCategory;
import com.natsuyami.inventory.model.Product;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.model.ShopProduct;
import com.natsuyami.inventory.repository.ProductRepository;
import com.natsuyami.inventory.repository.ShopProductRepository;
import com.natsuyami.inventory.service.services.CategoryService;
import com.natsuyami.inventory.service.services.FoodService;
import com.natsuyami.inventory.service.services.ShopService;

import com.natsuyami.inventory.service.services.management.FoodToolService;
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

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
public class FoodToolServiceTest {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodToolService foodToolService;

    @MockBean
    private ShopService shopService;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ShopProductRepository shopProductRepository;


    private ProductDetailsDto productDetailsDto;
    private CategoryDto categoryDto;

    private Product product;
    private ShopProduct shopProduct;
    private Shop shop;
    private ProductCategory productCategory;

    @TestConfiguration
    static class ProductServiceTestConfiguration {
        @Bean
        public FoodService foodService() {
            return new FoodService();
        }

        @Bean
        public FoodToolService foodToolService() {
            return new FoodToolService();
        }
    }

    @Before
    public void initialized() {
        productDetailsDto = new ProductDetailsDto();
        productDetailsDto.setProductName("Test Name");
        productDetailsDto.setProductDescription("Test Description");
        productDetailsDto.setCurrency("PHP");
        productDetailsDto.setCreatedBy("Created By Test");
        productDetailsDto.setPrice(BigDecimal.valueOf(120.00));
        productDetailsDto.setQuantity(BigDecimal.valueOf(10l));
        productDetailsDto.setUnit("piece");
        productDetailsDto.setShopId(0);

        product = new Product();
        BeanUtils.copyProperties(productDetailsDto, product);
        product.setId(1l);

        shopProduct = new ShopProduct();
        BeanUtils.copyProperties(productDetailsDto, shopProduct);
        shopProduct.setProduct(product);

        shop = new Shop();
        shop.setId(1l);
        shop.setShopName("Test Shop Name");
    }

    @Test
    public void successCreateFood() {
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
        ProductDetailsDto result = foodToolService.create(productDetailsDto);

        assertThat(result.getId(), equalTo(product.getId()));
        assertThat(result.getPrice(), is(nullValue()));
    }

    @Test
    public void successCreateFoodDetails() {
        productDetailsDto.setShopId(1l);
        Mockito.when(shopService.findById(Mockito.anyLong())).thenReturn(shop);
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
        Mockito.when(shopProductRepository.save(Mockito.any())).thenReturn(shopProduct);
        ProductDetailsDto result = foodToolService.create(productDetailsDto);

        assertThat(product.getId(), equalTo(result.getId()));
        assertThat(productDetailsDto.getPrice(), equalTo(result.getPrice()));
    }
}
