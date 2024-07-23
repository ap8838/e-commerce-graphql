package com.atomtechnologies.ecommerce.demo.fetcher;

import com.atomtechnologies.ecommerce.demo.domain.Category;
import com.atomtechnologies.ecommerce.demo.filter.GetCategoriesInput;
import com.atomtechnologies.ecommerce.demo.service.CategoryService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class CategoryFetcher {
    private final CategoryService categoryService;

    public CategoryFetcher(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @DgsQuery
    public List<Category> getCategories(@InputArgument GetCategoriesInput input) {
        return categoryService.getCategories(input.getPage(), input.getSize());
    }
    @DgsQuery
    public Category getCategoryById(@InputArgument Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }
}