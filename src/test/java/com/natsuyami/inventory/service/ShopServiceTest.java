package com.natsuyami.inventory.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.natsuyami.inventory.dto.ShopDto;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.repository.ShopRepository;
import com.natsuyami.inventory.service.services.AddressService;
import com.natsuyami.inventory.service.encryption.Encryption;
import com.natsuyami.inventory.service.services.management.ShopToolService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;

@RunWith(SpringRunner.class)
public class ShopServiceTest {

    @Autowired
    private ShopToolService shopToolService;

    @MockBean
    private AddressService addressService;

    @MockBean
    private ShopRepository shopRepository;

    @MockBean
    private MockHttpServletRequest httpServletRequest;

    @MockBean
    private Encryption encryption;

    private ShopDto shopDto;

    private Address address;
    private Shop shop;

    @TestConfiguration
    static class ShopServiceTestConfiguration {
        @Bean
        public ShopToolService shopToolService() {
            return new ShopToolService();
        }
    }

    @Before
    public void initialized() {
        shopDto = new ShopDto();

        shopDto.setHourClosing("11:00:00");
        shopDto.setHourOpening("8:00:00");
        shopDto.setDaysOfOperation("weekdays");
        shopDto.setShopDescription("Test shop description");
        shopDto.setShopName("Test shop name");
        shopDto.setAddressId(1l);

        shop = new Shop();
        BeanUtils.copyProperties(shopDto, shop);
        shop.setClosingHour(Time.valueOf("11:00:00"));
        shop.setOpenHour(Time.valueOf("8:00:00"));
        shop.setId(1l);

        address = new Address();
        address.setId(1l);
        address.setAddressBlock("Block address village");
        address.setBaranggay("baranggay test");
        address.setCity("city test");
        address.setRegion("region test");
    }

    @Test
    public void successCreateShop() {
        Mockito.when(encryption.jwtConverter()).thenReturn("createdBy");
        Mockito.when(addressService.findById(Mockito.anyLong())).thenReturn(address);
        Mockito.when(shopRepository.save(Mockito.any())).thenReturn(shop);

        ShopDto result = shopToolService.create(shopDto);

        assertThat(result.getId(), equalTo(shop.getId()));
    }

}
