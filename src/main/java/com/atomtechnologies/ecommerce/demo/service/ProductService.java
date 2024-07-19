package com.atomtechnologies.ecommerce.demo.service;

import com.atomtechnologies.ecommerce.demo.domain.Category;
import com.atomtechnologies.ecommerce.demo.domain.Product;
import com.atomtechnologies.ecommerce.demo.persistence.CategoryRepository;
import com.atomtechnologies.ecommerce.demo.persistence.ProductRepository;
import org.springframework.stereotype.Service;
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product addProduct(String name, byte[] image, Long categoryId, String description) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = Product.builder()
                .name(name)
                .image(image)
                .description(description)
                .category(category)
                .build();
        return productRepository.save(product);
    }
}

