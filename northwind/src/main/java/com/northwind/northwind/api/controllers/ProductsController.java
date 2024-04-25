package com.northwind.northwind.api.controllers;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.entities.dtos.ProductWithCategoryResponse;
import com.northwind.northwind.entities.dtos.requests.CreateProductRequest;
import com.northwind.northwind.entities.dtos.requests.UpdateProductRequest;
import com.northwind.northwind.entities.dtos.responses.GetAllProductsResponse;
import com.northwind.northwind.entities.dtos.responses.GetByProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<GetAllProductsResponse>>> getAll() {
        DataResult<List<GetAllProductsResponse>> dataResult = productService.getAll();
        return ResponseEntity.ok(dataResult);
    }

    @GetMapping("/getAllSorted")
    DataResult<List<GetAllProductsResponse>> getAllSorted(@RequestParam String typeOfSort) {
        return productService.getAllSorted(typeOfSort);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<GetAllProductsResponse>> getAll(int pageNo, int pageSize) {
        return productService.getAll(pageNo - 1, pageSize);
    }

    @GetMapping("/getById")
    public ResponseEntity<Result> getById(@RequestParam int id) {
        Result result = productService.getById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@RequestBody CreateProductRequest createProductRequest) {
        Result result = productService.add(createProductRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id) {
        Result result = productService.delete(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(int id, @RequestBody UpdateProductRequest updateProductRequest) {
        Result result = productService.update(id, updateProductRequest);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getByProductName")
    public DataResult<GetByProductResponse> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
    }

    @GetMapping("/getByCategoryName")
    public DataResult<List<GetByProductResponse>> getByCategoryCategoryName(@RequestParam String categoryName) {
        return productService.getByCategoryCategoryName(categoryName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<GetByProductResponse> getByProductNameAndCategoryId(@RequestParam String productName, int categoryId) {
        return productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    public DataResult<List<GetByProductResponse>> getByProductNameOrCategoryId(@RequestParam String productName, int categoryId) {
        return productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<GetByProductResponse>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
        return productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<GetByProductResponse>> getByProductNameContains(@RequestParam String productName) {
        return productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<GetByProductResponse>> getByProductNameStartsWith(@RequestParam String productName) {
        return productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory")
    public DataResult<List<GetByProductResponse>> getByNameAndCategory(@RequestParam String productName, int categoryId) {
        return productService.getByNameAndCategory(productName, categoryId);
    }

    @GetMapping("/getProductWithCategoryResponseDetails")
    public DataResult<List<ProductWithCategoryResponse>> getProductWithCategoryResponseDetails() {
        return productService.getProductWithCategoryResponseDetails();
    }
}
