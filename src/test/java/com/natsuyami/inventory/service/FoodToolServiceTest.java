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
import com.natsuyami.inventory.service.services.type.CategoryService;
import com.natsuyami.inventory.service.services.product.FoodService;
import com.natsuyami.inventory.service.services.ShopService;

import com.natsuyami.inventory.service.encryption.Encryption;
import com.natsuyami.inventory.service.services.management.product.FoodToolService;
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

import javax.servlet.http.HttpServletRequest;
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

    @MockBean
    private Encryption encryption;

    @MockBean
    private HttpServletRequest request;

    private ProductDetailsDto productDetailsDto;
    private CategoryDto categoryDto;

    private Product product;
    private ShopProduct shopProduct;
    private Shop shop;
    private ProductCategory productCategory;
    private Product productTwo;

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
        productDetailsDto.setBrandName("Test Brand Name");
        productDetailsDto.setCurrency("PHP");
        productDetailsDto.setCategoryId(1l);
        productDetailsDto.setCreatedBy("Created By Test");
        productDetailsDto.setPrice(BigDecimal.valueOf(120.00));
        productDetailsDto.setQuantity(BigDecimal.valueOf(10l));
        productDetailsDto.setUnit("piece");
        productDetailsDto.setShopId(0);
        productDetailsDto.setId(1l);

        productCategory = new ProductCategory();
        productCategory.setId(1l);
        productCategory.setCategory("Test Category");

        product = new Product();
        BeanUtils.copyProperties(productDetailsDto, product);
        product.setProductCategory(productCategory);

        shopProduct = new ShopProduct();
        BeanUtils.copyProperties(productDetailsDto, shopProduct);
        shopProduct.setId(1l);
        shopProduct.setProduct(product);

        shop = new Shop();
        shop.setId(1l);
        shop.setShopName("Test Shop Name");

        productTwo = new Product();
        productTwo.setId(2);
        productTwo.setProductName("Magic Sarap Name");
        productTwo.setBrandName("Brand two");
        productTwo.setProductDescription("Test Desc");
        productTwo.setCreatedBy("CreatedBy");
        productTwo.setProductCategory(productCategory);
    }

    @Test
    public void successCreateFood() {
        productDetailsDto.setId(0);
        Mockito.when(encryption.jwtConverter()).thenReturn("createdBy");
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
        ProductDetailsDto result = foodToolService.create(productDetailsDto);

        assertThat(result.getId(), equalTo(product.getId()));
        assertThat(result.getPrice(), is(nullValue()));
    }

    @Test
    public void successCreateFoodDetails() {
        productDetailsDto.setShopId(1l);
        productDetailsDto.setId(0);

        Mockito.when(encryption.jwtConverter()).thenReturn("createdBy");
        Mockito.when(shopService.findById(Mockito.anyLong())).thenReturn(shop);
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
        Mockito.when(shopProductRepository.save(Mockito.any())).thenReturn(shopProduct);
        ProductDetailsDto result = foodToolService.create(productDetailsDto);

        assertThat(product.getId(), equalTo(result.getId()));
        assertThat(productDetailsDto.getPrice(), equalTo(result.getPrice()));
    }
}
