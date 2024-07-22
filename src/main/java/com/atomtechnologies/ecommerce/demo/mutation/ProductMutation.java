package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.domain.Product;
import com.atomtechnologies.ecommerce.demo.service.ProductService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

@DgsComponent
public class ProductMutation {
    private final ProductService productService;

    public ProductMutation(ProductService productService) {
        this.productService = productService;
    }

    @DgsMutation
    public Product addProduct(String name, MultipartFile image, String description, Long categoryId) {
        try {
            byte[] imageBytes = image.getBytes();
            return productService.addProduct(name, imageBytes, description, categoryId);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store image", e);
        }
    }
}