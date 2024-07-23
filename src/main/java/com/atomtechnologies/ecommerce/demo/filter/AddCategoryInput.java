package com.atomtechnologies.ecommerce.demo.filter;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCategoryInput {
    private String name;
    private String description;
}