package com.atomtechnologies.ecommerce.demo.fetcher;

import com.atomtechnologies.ecommerce.demo.domain.Category;
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
    public List<Category> getPaginatedCategories(@InputArgument int page, @InputArgument int size) {
        return categoryService.getPaginatedCategories(page, size);
    }
}