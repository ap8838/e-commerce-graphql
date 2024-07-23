package com.atomtechnologies.ecommerce.demo.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoriesInput {
    private  int page ;
    private int size ;
}
