package com.roy.spring5webapp.repository;

import com.roy.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Roy 23-10-2021
 *
 * setting up Spring data JPA repository
 *
 * runtime spring will implement the necessary codes
 * of all CRUD operations
 */
public interface AuthorRepository extends CrudRepository<Author,Long> {
}
