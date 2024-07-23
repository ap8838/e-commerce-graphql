package com.atomtechnologies.ecommerce.demo.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetReviewsInput {
    private Long productId;
    private int page;
    private int size;
}