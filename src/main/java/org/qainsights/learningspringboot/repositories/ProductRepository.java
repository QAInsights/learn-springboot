package org.qainsights.learningspringboot.repositories;

import org.qainsights.learningspringboot.dtos.ProductSummary;
import org.qainsights.learningspringboot.entities.Category;
import org.qainsights.learningspringboot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCriteriaRepository, JpaSpecificationExecutor<Product> {


    List<Product> findByName(String name);

    List<Product> findByNameLike(String name);

    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);

    List<Product> findByNameStartingWith(String name);

    List<Product> findByNameEndingWith(String name);

    List<Product> findByPrice(BigDecimal price);

    List<Product> findByPriceGreaterThan(BigDecimal priceIsGreaterThan);

    List<Product> findByPriceLessThanEqual(BigDecimal priceIsLessThan);

    List<Product> findByDescription(String description);

    List<Product> findByDescriptionNotNull(String description);

    List<Product> findByNameOrderByCategoryDesc(String name);

    List<Product> findTop5ByName(String name);

//    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
//    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


//    @Query("select p from Product p where p.price between ?1 and ?2 order by p.name")
    @Procedure("findProductsByPrice")
    List<Product> findProducts(BigDecimal min, BigDecimal max);
//    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


    @Query("select count(p) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.price = :newPrice and p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    List<ProductSummary> findByCategory(@Param("category") Category category);
}