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

    //All the below query are declared or derived query methods
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

    //Projection Demo with Native Query
  //  @Query("SELECT p.title AS title, p.price AS price FROM Product p WHERE p.id = 5") This is HQL query
    @Query(value = "SELECT p.title, p.price FROM products p WHERE p.id = 5", nativeQuery = true)
    List<ProductWithTitleAndPrice> findTitleAndPriceById();

    // select all the products where category name = 'Electronics' this is Joined Query
    // select p.* from products p join categories c on p.category_id=c.id where c.name='Electronics'
    // If we want to filter values based on the field of associated entity we can use _ (underscore) to navigate
    Optional<Product> findByCategory_Name(String categoryName);

}
