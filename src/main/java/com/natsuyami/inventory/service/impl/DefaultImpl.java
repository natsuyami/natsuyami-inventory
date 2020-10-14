package com.natsuyami.inventory.service.impl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Generic operation for all features without any form of restriction e.g. authentication, authorization
 * implemented to all features
 * @param <R> - return type to be assign to the service that will be implemented
 */
public interface DefaultImpl<R, S> {

    List<S> getAll(Pageable pageable);

    R getById(long id);

    List<R> search(String search);
}
