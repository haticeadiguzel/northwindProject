package com.northwind.northwind.business.concretes;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.core.utilities.results.SuccessDataResult;
import com.northwind.northwind.core.utilities.results.SuccessResult;
import com.northwind.northwind.dataAccess.abstracts.ProductRepository;
import com.northwind.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(productRepository.findAll(), "Data listed.");
    }

    @Override
    public Result getById(int id) {
        return new SuccessDataResult<Product>(productRepository.findById(id).orElseThrow(), "Product listed.");
    }

    @Override
    public Result add(Product product) {
        productRepository.save(product);
        return new SuccessResult("Product added.");
    }

    @Override
    public Result delete(int id) {
        productRepository.deleteById(id);
        return new SuccessResult("Product deleted.");
    }

    @Override
    public Result update(Product product) {
        productRepository.save(product);
        return new SuccessResult("Product updated.");
    }
}
