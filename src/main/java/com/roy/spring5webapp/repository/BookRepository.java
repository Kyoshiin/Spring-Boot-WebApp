package com.roy.spring5webapp.repository;

import com.roy.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Roy 23-10-2021
 */
public interface BookRepository extends CrudRepository<Book,Long> {
}
