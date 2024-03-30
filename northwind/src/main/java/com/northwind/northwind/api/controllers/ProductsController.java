package com.northwind.northwind.api.controllers;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.entities.concretes.Product;
import com.northwind.northwind.entities.dtos.ProductWithCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getAllSorted")
    DataResult<List<Product>> getAllSorted(@RequestParam String typeOfSort) {
        return productService.getAllSorted(typeOfSort);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        return productService.getAll(pageNo - 1, pageSize);
    }

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product) {
        return productService.add(product);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable int id) {
        return productService.delete(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, int categoryId) {
        return productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName, int categoryId) {
        return productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(@RequestParam  List<Integer> categories) {
        return productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam  String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam  String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName, int categoryId) {
        return productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getProductWithCategoryResponseDetails")
    public DataResult<List<ProductWithCategoryResponse>> getProductWithCategoryResponseDetails() {
        return productService.getProductWithCategoryResponseDetails();
    }
}
