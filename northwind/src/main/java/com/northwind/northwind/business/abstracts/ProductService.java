package com.northwind.northwind.business.abstracts;

import com.northwind.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
