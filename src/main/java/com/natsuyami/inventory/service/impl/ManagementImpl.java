package com.natsuyami.inventory.service.impl;

public interface ManagementImpl<R> {

    R create(R obj);

    R update (R obj);

    boolean delete (long id);
}
