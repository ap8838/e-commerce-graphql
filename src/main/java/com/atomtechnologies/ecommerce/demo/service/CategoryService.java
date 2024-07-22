package com.atomtechnologies.ecommerce.demo.service;

import com.atomtechnologies.ecommerce.demo.domain.Category;
import com.atomtechnologies.ecommerce.demo.persistence.CategoryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(String name, String description) {
        Category category = Category.builder()
                .name(name)
                .description(description)
                .build();
        return categoryRepository.save(category);
    }

    public List<Category> getPaginatedCategories(int page, int size) {
        return categoryRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}