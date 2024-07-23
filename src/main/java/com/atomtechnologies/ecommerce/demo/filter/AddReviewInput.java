package com.atomtechnologies.ecommerce.demo.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddReviewInput {
    private Long productId;
    private Long userId;
    private Long rating;
    private String comment;
}
