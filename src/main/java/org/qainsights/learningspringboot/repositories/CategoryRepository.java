package org.qainsights.learningspringboot.repositories;

import org.qainsights.learningspringboot.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
    Category getFirstById(Byte id);
}