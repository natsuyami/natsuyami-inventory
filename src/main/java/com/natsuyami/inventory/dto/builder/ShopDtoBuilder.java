package com.natsuyami.inventory.dto.builder;

import com.natsuyami.inventory.dto.ShopDto;
import com.natsuyami.inventory.model.Shop;
import org.springframework.beans.BeanUtils;


public class ShopDtoBuilder {

    protected static ShopDtoBuilder instance;

    protected ShopDtoBuilder() {}

    public static ShopDtoBuilder getInstance() {
        if (instance == null) {
            instance = new ShopDtoBuilder();
        }

        return instance;
    }

    public ShopDto build(Shop shop, long addressId) {
        ShopDto shopDto = new ShopDto();
        BeanUtils.copyProperties(shop, shopDto);
        shopDto.setHourClosing(String.valueOf(shop.getClosingHour()));
        shopDto.setHourOpening(String.valueOf(shop.getOpenHour().toString()));
        shopDto.setAddressId(addressId);

        return shopDto;
    }
}
