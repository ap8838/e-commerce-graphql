package com.atomtechnologies.ecommerce.demo.mutation;

import com.atomtechnologies.ecommerce.demo.domain.Product;
import com.atomtechnologies.ecommerce.demo.service.ProductService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;

@DgsComponent
public class ProductMutation {

    private final ProductService productService;

    public ProductMutation(ProductService productService) {
        this.productService = productService;
    }

    @DgsMutation
    public Product addProduct(String name, byte[] image, Long categoryId ,  String description) {
        return productService.addProduct(name, image, categoryId , description);
    }
}
