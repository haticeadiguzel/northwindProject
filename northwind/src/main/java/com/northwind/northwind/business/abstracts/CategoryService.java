package com.northwind.northwind.business.abstracts;

import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.entities.dtos.responses.GetAllCategoriesResponse;

import java.util.List;

public interface CategoryService {
    DataResult<List<GetAllCategoriesResponse>> getAll();
}
