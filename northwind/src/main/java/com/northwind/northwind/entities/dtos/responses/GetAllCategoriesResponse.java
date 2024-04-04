package com.northwind.northwind.entities.dtos.responses;

import com.northwind.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCategoriesResponse {
    private int id;
    private String categoryName;
    private List<Product> products;
}
