package com.atomtechnologies.ecommerce.demo.fetcher;

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
    public List<Product> getPaginatedProducts(@InputArgument int page, @InputArgument int size) {
        return productService.getPaginatedProducts(page, size);
    }

    @DgsQuery
    public List<Product> getProductsByCategory(@InputArgument Long categoryId, @InputArgument int page, @InputArgument int size) {
        return productService.getProductsByCategory(categoryId, page, size);
    }
}