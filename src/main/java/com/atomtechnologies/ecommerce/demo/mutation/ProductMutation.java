package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.domain.Product;
import com.atomtechnologies.ecommerce.demo.service.ProductService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class ProductMutation {
    private final ProductService productService;

    public ProductMutation(ProductService productService) {
        this.productService = productService;
    }

    @DgsMutation
    public Product addProduct(@InputArgument String name, @InputArgument String description, @InputArgument Long categoryId) {
        return productService.addProduct(name, description, categoryId);
    }
}