package com.natsuyami.inventory.service.services.management;

import com.natsuyami.inventory.dto.ShopDto;
import com.natsuyami.inventory.dto.builder.ShopDtoBuilder;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.model.Shop;
import com.natsuyami.inventory.repository.ShopRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.services.AddressService;
import com.natsuyami.inventory.service.services.ShopService;
import com.natsuyami.inventory.service.encryption.Encryption;
import com.natsuyami.inventory.validation.ShopValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class ShopToolService extends ShopService implements ManagementImpl<ShopDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShopToolService.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private Encryption encryption;

    /**
     * create one shop
     * @param shopDto - shop data to be saved
     * @return ShopDto - data of save shop
     */
    @Override
    public ShopDto create(ShopDto shopDto) {
        LOGGER.info("Initialized ShopToolService create() method with param={{}}", shopDto);
        Shop shop = createShop(shopDto);

        return ShopDtoBuilder.getInstance().build(shop, shopDto.getAddressId());
    }

    @Override
    public ShopDto update(ShopDto shopDetailsDto) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    /**
     * validate shop data then saved
     * @param shopDto - shop data to be saved
     * @return Shop - data of saved shop
     */
    public Shop createShop(ShopDto shopDto) {
        LOGGER.info("Initialized ShopService createShop() method with param={{}}", shopDto);
        ShopValidation.getInstance().validate(shopDto); // initial validation of shop data without any api calls
        Address address = addressService.findById(shopDto.getAddressId()); // find assigned address to the shop

        Shop shop = new Shop();
        BeanUtils.copyProperties(shopDto, shop);
        shop.setOpenHour(Time.valueOf(shopDto.getHourOpening()));
        shop.setClosingHour(Time.valueOf(shopDto.getHourClosing()));
        shop.setAddress(address);
        shop.setCreatedBy(encryption.jwtConverter());

        LOGGER.info("Saving shop shopName={{}}", shop.getShopName());
        shop = shopRepository.save(shop);

        return shop;
    }
}
