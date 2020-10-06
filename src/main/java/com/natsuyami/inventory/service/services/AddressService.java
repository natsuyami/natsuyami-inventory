package com.natsuyami.inventory.service.services;

import com.natsuyami.inventory.dto.AddressDto;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.repository.AddressRepository;
import com.natsuyami.inventory.service.impl.DefaultImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements DefaultImpl<AddressDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAll() {
        return null;
    }

    @Override
    public AddressDto getById(long id) {
        return null;
    }

    @Override
    public List<AddressDto> search(String keyword) {
        return null;
    }

    /**
     * find address by its id, otherwise null if id not exist
     * @param id - address id, type long
     * @return Address - address data
     */
    public Address findById (long id) {
        LOGGER.info("Initialized AddressService findById() method with id={{}}", id);
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()) {
            LOGGER.info("Found the address with city={{}}", address.get().getCity());
            return address.get();
        } else {
            LOGGER.info("Cannot find address");
            return null;
        }
    }
}
