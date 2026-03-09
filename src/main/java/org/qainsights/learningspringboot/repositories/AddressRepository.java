package org.qainsights.learningspringboot.repositories;

import org.qainsights.learningspringboot.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}