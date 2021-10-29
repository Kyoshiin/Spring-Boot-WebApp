package com.roy.spring5webapp.repository;


import com.roy.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Roy 28-10-2021
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
