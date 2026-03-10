package org.qainsights.learningspringboot.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.qainsights.learningspringboot.entities.Category;
import org.qainsights.learningspringboot.entities.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository{

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        if(name != null)
            predicates.add(cb.like(root.get("name"), "%" + name + "%"));
        if(minPrice != null)
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
        if(maxPrice != null)
            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), maxPrice));

        cq.select(root).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public List<Product> findProductsByCategoryCriteria(String category) {



        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        if(category != null){
            Join<Product, Category> categoryJoin = root.join("category", JoinType.INNER);

            predicates.add(criteriaBuilder.like(categoryJoin.get("name"), "%" + category + "%"));
        }

        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(criteriaQuery).getResultList();

    }
}
