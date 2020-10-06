package com.natsuyami.inventory.service.services;

import com.natsuyami.inventory.dto.ShopDto;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.repository.ShopRepository;
import com.natsuyami.inventory.service.impl.DefaultImpl;
import com.natsuyami.inventory.validation.ShopValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService implements DefaultImpl<ShopDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopService.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public List<ShopDto> getAll() {
        return null;
    }

    @Override
    public ShopDto getById(long id) {
        return null;
    }

    @Override
    public List<ShopDto> search(String keyword) {
        return null;
    }

    /**
     * find shop by its id, if no shop found then return null
     * @param id - id of the shop, type long
     * @return Shop - shop data
     */
    public Shop findById(long id) {
        LOGGER.info("Initialized ShopService findbyId() method with shopId={{}}", id);
        Optional<Shop> shop = shopRepository.findById(id);
        if (shop.isPresent()) {
            LOGGER.info("Found the shop with name={{}}", shop.get().getShopName());
            return shop.get();
        } else {
            LOGGER.info("shop cannot be find");
            return null;
        }
    }
}
