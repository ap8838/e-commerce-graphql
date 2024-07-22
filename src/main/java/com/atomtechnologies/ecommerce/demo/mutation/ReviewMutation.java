package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.domain.Review;
import com.atomtechnologies.ecommerce.demo.service.ReviewService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class ReviewMutation {
    private final ReviewService reviewService;

    public ReviewMutation(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DgsMutation
    public Review addReview(@InputArgument Long productId, @InputArgument Long userId,
                            @InputArgument Long rating, @InputArgument String comment) {
        return reviewService.addReview(productId, userId, rating, comment);
    }
}