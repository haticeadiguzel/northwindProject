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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @GetMapping("/getall")
    public DataResult<List<GetAllProductsResponse>> getAll() {
        return productService.getAll();
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
    public Result getById(@RequestParam int id) {
        return productService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateProductRequest createProductRequest) {
        return productService.add(createProductRequest);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return productService.delete(id);
    }

    @PutMapping("/update")
    public Result update(@RequestBody UpdateProductRequest updateProductRequest) {
        return productService.update(updateProductRequest);
    }

    @GetMapping("/getByProductName")
    public DataResult<GetByProductResponse> getByProductName(@RequestParam String productName) {
        return productService.getByProductName(productName);
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
