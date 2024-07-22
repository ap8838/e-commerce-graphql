package com.atomtechnologies.ecommerce.demo.persistence;

import com.atomtechnologies.ecommerce.demo.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}