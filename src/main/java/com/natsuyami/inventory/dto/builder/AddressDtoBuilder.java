package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.AddressDto;
import com.natsuyami.inventory.model.Address;
import org.springframework.beans.BeanUtils;

public class AddressDtoBuilder {

    protected static AddressDtoBuilder instance;

    protected AddressDtoBuilder() {}

    public static AddressDtoBuilder getInstance() {
        if (instance == null) {
            instance = new AddressDtoBuilder();
        }

        return instance;
    }

    public AddressDto build(Address address) {
        AddressDto addressDto = new AddressDto();
        BeanUtils.copyProperties(address, addressDto);

        return addressDto;
    }
}
