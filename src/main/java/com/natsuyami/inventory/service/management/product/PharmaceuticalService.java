package com.natsuyami.inventory.service.management.product;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.service.impl.ProductImpl;

import java.util.List;

public class PharmaceuticalService implements ProductImpl {

    @Override
    public ProductDetailsDto create(ProductDetailsDto obj) {
        return null;
    }

    @Override
    public ProductDetailsDto update(ProductDetailsDto obj) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public List<ProductDetailsDto> getAll() {
        return null;
    }

    @Override
    public ProductDetailsDto getById(long id) {
        return null;
    }

    @Override
    public ProductDetailsDto search(String keyword) {
        return null;
    }
}
