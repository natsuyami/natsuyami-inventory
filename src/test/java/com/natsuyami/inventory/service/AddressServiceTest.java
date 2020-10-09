package com.natsuyami.inventory.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import com.natsuyami.inventory.dto.AddressDto;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.repository.AddressRepository;
import com.natsuyami.inventory.service.services.management.AddressToolService;
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
public class AddressServiceTest {

    @Autowired
    private AddressToolService addressToolService;

    @MockBean
    private AddressRepository addressRepository;

    private AddressDto addressDto;

    private Address address;

    @TestConfiguration
    static class AddressServiceTestConfiguration {
        @Bean
        public AddressToolService addressToolService() {
            return new AddressToolService();
        }
    }

    @Before
    public void initialized() {
        addressDto = new AddressDto();
        addressDto.setAddressBlock("Block address village");
        addressDto.setBaranggay("baranggay test");
        addressDto.setCity("city test");
        addressDto.setRegion("region test");
        addressDto.setProvince("province test");

        address = new Address();
        BeanUtils.copyProperties(addressDto, address);
        address.setId(1l);
    }

    @Test
    public void successCreateAddress() {
        Mockito.when(addressRepository.save(Mockito.any())).thenReturn(address);
        AddressDto result = addressToolService.create(addressDto);

        assertThat(result.getId(), equalTo(address.getId()));
        assertThat(result.getRegion(), equalTo(address.getRegion()));
    }
}
