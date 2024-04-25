package com.northwind.northwind.business.abstracts;

import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.entities.dtos.ProductWithCategoryResponse;
import com.northwind.northwind.entities.dtos.requests.CreateProductRequest;
import com.northwind.northwind.entities.dtos.requests.UpdateProductRequest;
import com.northwind.northwind.entities.dtos.responses.GetAllProductsResponse;
import com.northwind.northwind.entities.dtos.responses.GetByProductResponse;

import java.util.List;

public interface ProductService {
    DataResult<List<GetAllProductsResponse>> getAll();

    DataResult<List<GetAllProductsResponse>> getAllSorted(String typeOfSort);

    DataResult<List<GetAllProductsResponse>> getAll(int pageNo, int pageSize);

    Result getById(int id);

    Result add(CreateProductRequest createProductRequest);

    Result delete(int id);

    Result update(int id, UpdateProductRequest updateProductRequest);

    DataResult<GetByProductResponse> getByProductName(String productName);

    DataResult<List<GetByProductResponse>> getByCategoryCategoryName(String categoryName);

    DataResult<GetByProductResponse> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<GetByProductResponse>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<GetByProductResponse>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<GetByProductResponse>> getByProductNameContains(String productName);

    DataResult<List<GetByProductResponse>> getByProductNameStartsWith(String productName);

    DataResult<List<GetByProductResponse>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryResponse>> getProductWithCategoryResponseDetails();
}
