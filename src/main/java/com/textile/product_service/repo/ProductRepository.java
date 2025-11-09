package com.textile.product_service.repo;

import com.textile.product_service.models.Product;
import com.textile.product_service.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Declared Query Methods can be added here


    @Override
    Optional<Product> findById(Long aLong);

    @Override
    List<Product> findAll();

    //select * from products where title=?
    List<Product> findByTitle(String title);

    //select * from products where title like %?%
    List<Product> findByTitleContains(String title);

    //select * from products where price>= start and price<=end
    List<Product> findByPriceBetween(Double start, Double end);

    List<Product> findByTitleContainsIgnoreCaseAndPriceBetween(String title, Double start, Double end);

    List<Product> findByCreatedAtBetween(Date start, Date end);

    @Override
    void deleteById(Long aLong);

    Product save(Product product);

    @Query(value = "SELECT p.title, p.price FROM products p WHERE p.id = 5", nativeQuery = true)
    List<ProductWithTitleAndPrice> findTitleAndPriceById();

    Optional<Product> findByCategory_Name(String categoryName);

}
