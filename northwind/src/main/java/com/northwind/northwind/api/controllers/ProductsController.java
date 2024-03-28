package com.northwind.northwind.api.controllers;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/products")
@AllArgsConstructor
@RestController
public class ProductsController {
    private ProductService productService;

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
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
    public Result update(Product product) {
        return productService.update(product);
    }
}
