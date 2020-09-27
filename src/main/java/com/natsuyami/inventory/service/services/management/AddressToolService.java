package com.natsuyami.inventory.service.services.management;

import com.natsuyami.inventory.dto.AddressDto;
import com.natsuyami.inventory.dto.builder.AddressDtoBuilder;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.repository.AddressRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.services.AddressService;
import com.natsuyami.inventory.validation.AddressValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressToolService extends AddressService implements ManagementImpl<AddressDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressToolService.class);

    @Autowired
    private AddressRepository addressRepository;

    /**
     * create new address
     * @param addressDto  - address data to be saved
     * @return AddressDto - data of saved address
     */
    @Override
    public AddressDto create(AddressDto addressDto) {
        LOGGER.info("Initialized AddressToolService create() method with param={{}}", addressDto);
        AddressValidation.getInstance().validate(addressDto); // initial validation of address data without any api calls
        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);

        LOGGER.info("Saving address city={{}}", address.getCity());
        address = addressRepository.save(address);

        return AddressDtoBuilder.getInstance().build(address);
    }

    @Override
    public AddressDto update(AddressDto obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
