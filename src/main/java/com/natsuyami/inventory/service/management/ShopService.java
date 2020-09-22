package com.natsuyami.inventory.service.management;

import com.natsuyami.inventory.dto.ShopDto;
import com.natsuyami.inventory.dto.builder.ShopDtoBuilder;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.repository.ShopRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.impl.OpenImpl;
import com.natsuyami.inventory.validation.product.ShopValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements ManagementImpl<ShopDto>, OpenImpl<ShopDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public ShopDto create(ShopDto ShopDto) {
        Shop shop = createShop(ShopDto);

        return ShopDtoBuilder.getInstance().build(shop);
    }

    @Override
    public ShopDto update(ShopDto shopDetailsDto) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<ShopDto> getAll() {
        return null;
    }

    @Override
    public ShopDto getById(long id) {
        return null;
    }

    @Override
    public ShopDto search(String keyword) {
        return null;
    }

    public Shop createShop(ShopDto shopDto) {
        ShopValidation.getInstance().validate(shopDto);
        Address address = addressService.findById(shopDto.getAddressId());

        Shop shop = new Shop();
        BeanUtils.copyProperties(shopDto, shop);
        shop.setAddress(address);

        shop = shopRepository.save(shop);

        return shop;
    }

    public Shop findbyId(long id) {
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent()) {
            return shop.get();
        } else {
            LOGGER.info("shop cannot be find");
            return null;
        }
    }
}
