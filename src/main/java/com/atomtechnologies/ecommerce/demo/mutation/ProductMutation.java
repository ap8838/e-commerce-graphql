package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.codegen.types.AddProductInput;
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
    public Product addProduct(@InputArgument AddProductInput input) {
        return productService.addProduct(input.getName(), input.getDescription(), input.getCategoryId());
    }
}