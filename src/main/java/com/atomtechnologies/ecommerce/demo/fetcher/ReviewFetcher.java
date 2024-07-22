package com.atomtechnologies.ecommerce.demo.fetcher;

import com.atomtechnologies.ecommerce.demo.domain.Review;
import com.atomtechnologies.ecommerce.demo.service.ReviewService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class ReviewFetcher {
    private final ReviewService reviewService;

    public ReviewFetcher(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DgsQuery
    public List<Review> getReviews(@InputArgument Long productId, @InputArgument int page, @InputArgument int size) {
        return reviewService.getReviews(productId, page, size);
    }
}