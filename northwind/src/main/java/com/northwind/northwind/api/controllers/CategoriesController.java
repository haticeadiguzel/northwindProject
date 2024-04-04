package com.northwind.northwind.api.controllers;

import com.northwind.northwind.business.abstracts.CategoryService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.entities.dtos.responses.GetAllCategoriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoriesController {
    private CategoryService categoryService;

    @GetMapping("/getall")
    public DataResult<List<GetAllCategoriesResponse>> getAll() {
        return categoryService.getAll();
    }
}
