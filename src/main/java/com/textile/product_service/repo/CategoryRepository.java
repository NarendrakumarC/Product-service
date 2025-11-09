package com.textile.product_service.repo;

import com.textile.product_service.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
   Optional<Category> findByName(String name);
   Category save(Category category);
}
