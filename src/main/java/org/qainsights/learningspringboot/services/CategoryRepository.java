package org.qainsights.learningspringboot.services;

import org.qainsights.learningspringboot.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
    Category getFirstById(Byte id);
}