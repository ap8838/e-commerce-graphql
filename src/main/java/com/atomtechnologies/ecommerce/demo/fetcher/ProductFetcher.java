package com.atomtechnologies.ecommerce.demo.fetcher;

import com.atomtechnologies.ecommerce.demo.types.GetProductsByCategoryInput;
import com.atomtechnologies.ecommerce.demo.types.GetProductsInput;
import com.atomtechnologies.ecommerce.demo.domain.Product;
import com.atomtechnologies.ecommerce.demo.service.ProductService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.List;

@DgsComponent
public class ProductFetcher {
    private final ProductService productService;

    public ProductFetcher(ProductService productService) {
        this.productService = productService;
    }

    @DgsQuery
    public List<Product> getProducts(@InputArgument GetProductsInput input) {
        return productService.getProducts(input.getPage(), input.getSize());
    }

    @DgsQuery
    public List<Product> getProductsByCategory(@InputArgument GetProductsByCategoryInput input) {
        return productService.getProductsByCategory(input.getCategoryId(), input.getPage(), input.getSize());
    }
}