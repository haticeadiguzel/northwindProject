package com.northwind.northwind.business.abstracts;

import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllSorted(String typeOfSort);
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    Result getById(int id);
    Result add(Product product);
    Result delete(int id);
    Result update(Product product);
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
