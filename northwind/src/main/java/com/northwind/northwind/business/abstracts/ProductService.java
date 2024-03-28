package com.northwind.northwind.business.abstracts;

import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result getById(int id);
    Result add(Product product);
    Result delete(int id);
    Result update(Product product);
}
