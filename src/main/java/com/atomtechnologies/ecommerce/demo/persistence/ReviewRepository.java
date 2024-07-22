package com.atomtechnologies.ecommerce.demo.persistence;

import com.atomtechnologies.ecommerce.demo.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByProductId(Long productId, Pageable pageable);
}
