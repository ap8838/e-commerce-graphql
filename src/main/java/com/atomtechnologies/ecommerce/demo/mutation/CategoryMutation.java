package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.codegen.types.AddCategoryInput;
import com.atomtechnologies.ecommerce.demo.domain.Category;
import com.atomtechnologies.ecommerce.demo.service.CategoryService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class CategoryMutation {
    private final CategoryService categoryService;

    public CategoryMutation(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DgsMutation
    public Category addCategory(@InputArgument AddCategoryInput input) {
        return categoryService.addCategory(input.getName(), input.getDescription());
    }
}