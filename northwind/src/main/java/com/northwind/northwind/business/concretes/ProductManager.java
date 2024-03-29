package com.northwind.northwind.business.concretes;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.core.utilities.results.SuccessDataResult;
import com.northwind.northwind.core.utilities.results.SuccessResult;
import com.northwind.northwind.dataAccess.abstracts.ProductRepository;
import com.northwind.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAllSorted(String typeOfSort) {
        Sort sort = Sort.by(Sort.Direction.fromString(typeOfSort), "productName");
        return new SuccessDataResult<List<Product>>(productRepository.findAll(sort), "Data listed.");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<List<Product>>(productRepository.findAll(pageable).getContent(), "Data listed.");
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

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(productRepository.getByProductName(productName), "Product listed.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(productRepository.getByProductNameAndCategoryId(productName, categoryId), "Product listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productRepository.getByProductNameOrCategoryId(productName, categoryId), "Products listed.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productRepository.getByCategoryIdIn(categories), "Products listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(productRepository.getByProductNameContains(productName), "Products listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(productRepository.getByProductNameStartsWith(productName), "Products listed.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productRepository.getByNameAndCategory(productName, categoryId), "Products listed.");
    }
}
