package com.atomtechnologies.ecommerce.demo.service;

import com.atomtechnologies.ecommerce.demo.domain.Product;
import com.atomtechnologies.ecommerce.demo.domain.Review;
import com.atomtechnologies.ecommerce.demo.domain.User;
import com.atomtechnologies.ecommerce.demo.persistence.ProductRepository;
import com.atomtechnologies.ecommerce.demo.persistence.ReviewRepository;
import com.atomtechnologies.ecommerce.demo.persistence.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Review addReview(Long productId, Long userId, Long rating, String comment) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Review review = Review.builder()
                .product(product)
                .user(user)
                .rating(rating)
                .comment(comment)
                .build();
        return reviewRepository.save(review);
    }

    public List<Review> getReviews(Long productId, int page, int size) {
        return reviewRepository.findByProductId(productId, PageRequest.of(page, size)).getContent();
    }
}