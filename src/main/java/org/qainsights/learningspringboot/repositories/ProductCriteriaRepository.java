package org.qainsights.learningspringboot.repositories;

import org.qainsights.learningspringboot.entities.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductCriteriaRepository {
    List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
    List<Product> findProductsByCategoryCriteria(String category);
}
