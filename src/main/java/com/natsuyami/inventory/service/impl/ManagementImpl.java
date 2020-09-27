package com.natsuyami.inventory.service.impl;

/**
 * common operation for management of the features
 * implemented mostly on all features
 * @param <R> - return type to be assign to the service that will be implemented
 */
public interface ManagementImpl<R> {

    R create(R obj);

    R update (R obj);

    boolean delete (long id);
}
