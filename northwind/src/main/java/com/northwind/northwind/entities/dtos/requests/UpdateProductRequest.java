package com.northwind.northwind.entities.dtos.requests;

import com.northwind.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
    private int id;
    private String productName;
    private double unitPrice;
    private short unitsInStock;
    private String quantityPerUnit;
    private Category category;
}
