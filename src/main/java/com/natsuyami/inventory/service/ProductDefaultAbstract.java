package com.natsuyami.inventory.service;

import com.natsuyami.inventory.dto.ProductDetailsDto;
import com.natsuyami.inventory.service.impl.DefaultImpl;

import java.util.ArrayList;
import java.util.List;

public abstract class ProductDefaultAbstract implements DefaultImpl<ProductDetailsDto> {

    @Override
    public List<ProductDetailsDto> getAll() {
        List<ProductDetailsDto> products = new ArrayList<>();
        return products;
    }

    @Override
    public ProductDetailsDto getById(long id) {
        return new ProductDetailsDto();
    }

    @Override
    public ProductDetailsDto search(String keyword) {
        return null;
    }

}
