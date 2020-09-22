package com.natsuyami.inventory.service.impl;

import java.util.List;

public interface OpenImpl<R> {

    List<R> getAll();

    R getById(long id);

    R search(String keyword);
}
