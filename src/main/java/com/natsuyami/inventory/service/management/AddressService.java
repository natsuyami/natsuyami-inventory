package com.natsuyami.inventory.service.management;

import com.natsuyami.inventory.dto.AddressDto;
import com.natsuyami.inventory.dto.builder.AddressDtoBuilder;
import com.natsuyami.inventory.model.Address;
import com.natsuyami.inventory.repository.AddressRepository;
import com.natsuyami.inventory.service.impl.ManagementImpl;
import com.natsuyami.inventory.service.impl.OpenImpl;
import com.natsuyami.inventory.validation.product.AddressValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements ManagementImpl<AddressDto>, OpenImpl<AddressDto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDto create(AddressDto addressDto) {
        AddressValidation.getInstance().validate(addressDto);
        Address address = new Address();
        BeanUtils.copyProperties(addressDto, address);

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

    @Override
    public List<AddressDto> getAll() {
        return null;
    }

    @Override
    public AddressDto getById(long id) {
        return null;
    }

    @Override
    public AddressDto search(String keyword) {
        return null;
    }

    public Address findById (long id) {
        Optional<Address> address = addressRepository.findById(id);

        if (address.isPresent()) {
            return address.get();
        } else {
            LOGGER.info("Cannot find address");
            return null;
        }
    }
}
