package com.atomtechnologies.ecommerce.demo.service;

import com.atomtechnologies.ecommerce.demo.domain.Category;
import com.atomtechnologies.ecommerce.demo.domain.Product;
import com.atomtechnologies.ecommerce.demo.persistence.CategoryRepository;
import com.atomtechnologies.ecommerce.demo.persistence.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product addProduct(String name, String description, int categoryId) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        Product product = Product.builder()
                .name(name)
                .description(description)
                .category(category)
                .build();
        return productRepository.save(product);
    }

    public List<Product> getProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public List<Product> getProductsByCategory(int categoryId, int page, int size) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        return productRepository.findAllByCategory(category, PageRequest.of(page, size)).getContent();
    }
}