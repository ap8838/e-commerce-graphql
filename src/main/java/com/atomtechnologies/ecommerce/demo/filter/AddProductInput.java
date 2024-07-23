package com.atomtechnologies.ecommerce.demo.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddProductInput {
    private String name;
    private String description;
    private Long categoryId;
}
