package com.northwind.northwind.api.controllers;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/products")
@AllArgsConstructor
@RestController
public class ProductsController {
    private ProductService productService;

    @GetMapping("/getall")
    public List<Product> getAll(){
        return productService.getAll();
    }
}
