package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.domain.Review;
import com.atomtechnologies.ecommerce.demo.service.ReviewService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;

@DgsComponent
public class ReviewMutation {

    private final ReviewService reviewService;

    public ReviewMutation(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DgsMutation
    public Review addReview(Long productId, Long userId, Long rating, String comment) {
        return reviewService.addReview(productId, userId, rating, comment);
    }
}