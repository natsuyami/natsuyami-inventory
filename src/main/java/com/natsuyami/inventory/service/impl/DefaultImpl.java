package com.natsuyami.inventory.service.impl;

import java.util.List;

/**
 * Generic operation for all features without any form of restriction e.g. authentication, authorization
 * implemented to all features
 * @param <R> - return type to be assign to the service that will be implemented
 */
public interface DefaultImpl<R> {

    List<R> getAll();

    R getById(long id);

    List<R> search(String keyword);
}
