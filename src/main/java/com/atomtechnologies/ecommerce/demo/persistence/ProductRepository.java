package com.atomtechnologies.ecommerce.demo.persistence;

import com.atomtechnologies.ecommerce.demo.domain.Category;
import com.atomtechnologies.ecommerce.demo.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByCategory(Category category, Pageable pageable);
}