package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.domain.Category;
import com.atomtechnologies.ecommerce.demo.service.CategoryService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;

@DgsComponent
public class CategoryMutation {

    private final CategoryService categoryService;

    public CategoryMutation(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DgsMutation
    public Category addCategory(String name, String description) {
        return categoryService.addCategory(name, description);
    }
}