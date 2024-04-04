package com.northwind.northwind.business.concretes;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.core.utilities.mappers.ModelMapperService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.Result;
import com.northwind.northwind.core.utilities.results.SuccessDataResult;
import com.northwind.northwind.core.utilities.results.SuccessResult;
import com.northwind.northwind.dataAccess.abstracts.ProductRepository;
import com.northwind.northwind.entities.concretes.Product;
import com.northwind.northwind.entities.dtos.ProductWithCategoryResponse;
import com.northwind.northwind.entities.dtos.requests.CreateProductRequest;
import com.northwind.northwind.entities.dtos.requests.UpdateProductRequest;
import com.northwind.northwind.entities.dtos.responses.GetAllProductsResponse;
import com.northwind.northwind.entities.dtos.responses.GetByIdProductResponse;
import com.northwind.northwind.entities.dtos.responses.GetByProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllProductsResponse>> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductsResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetAllProductsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllProductsResponse>>(productResponses, "Data listed.");
    }

    @Override
    public DataResult<List<GetAllProductsResponse>> getAllSorted(String typeOfSort) {
        Sort sort = Sort.by(Sort.Direction.fromString(typeOfSort), "productName");
        List<Product> products = productRepository.findAll(sort);
        List<GetAllProductsResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetAllProductsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllProductsResponse>>(productResponses, "Data listed.");
    }

    @Override
    public DataResult<List<GetAllProductsResponse>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        List<Product> products = productRepository.findAll(pageable).getContent();
        List<GetAllProductsResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetAllProductsResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllProductsResponse>>(productResponses, "Data listed.");
    }

    @Override
    public Result getById(int id) {
        Product product = productRepository.findById(id).orElseThrow();
        GetByIdProductResponse getByIdProductResponse = modelMapperService.forResponse().map(product, GetByIdProductResponse.class);

        return new SuccessDataResult<GetByIdProductResponse>(getByIdProductResponse, "Product listed.");
    }

    @Override
    public Result add(CreateProductRequest createProductRequest) {
        Product product = modelMapperService.forRequest().map(createProductRequest, Product.class);
        productRepository.save(product);

        return new SuccessResult("Product added.");
    }

    @Override
    public Result delete(int id) {
        productRepository.deleteById(id);

        return new SuccessResult("Product deleted.");
    }

    @Override
    public Result update(UpdateProductRequest updateProductRequest) {
        Product product = modelMapperService.forRequest().map(updateProductRequest, Product.class);
        productRepository.save(product);

        return new SuccessResult("Product updated.");
    }

    @Override
    public DataResult<GetByProductResponse> getByProductName(String productName) {
        Product product = productRepository.getByProductName(productName);
        GetByProductResponse getByProductResponse = modelMapperService.forResponse().map(product, GetByProductResponse.class);

        return new SuccessDataResult<GetByProductResponse>(getByProductResponse, "Product listed.");
    }

    @Override
    public DataResult<GetByProductResponse> getByProductNameAndCategoryId(String productName, int categoryId) {
        Product product = productRepository.getByProductNameAndCategoryId(productName, categoryId);
        GetByProductResponse getByProductResponse = modelMapperService.forResponse().map(product, GetByProductResponse.class);

        return new SuccessDataResult<GetByProductResponse>(getByProductResponse, "Product listed.");
    }

    @Override
    public DataResult<List<GetByProductResponse>> getByProductNameOrCategoryId(String productName, int categoryId) {
        List<Product> products = productRepository.getByProductNameOrCategoryId(productName, categoryId);
        List<GetByProductResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetByProductResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetByProductResponse>>(productResponses, "Products listed.");
    }

    @Override
    public DataResult<List<GetByProductResponse>> getByCategoryIdIn(List<Integer> categories) {
        List<Product> products = productRepository.getByCategoryIdIn(categories);
        List<GetByProductResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetByProductResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetByProductResponse>>(productResponses, "Products listed.");
    }

    @Override
    public DataResult<List<GetByProductResponse>> getByProductNameContains(String productName) {
        List<Product> products = productRepository.getByProductNameContains(productName);
        List<GetByProductResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetByProductResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetByProductResponse>>(productResponses, "Products listed.");
    }

    @Override
    public DataResult<List<GetByProductResponse>> getByProductNameStartsWith(String productName) {
        List<Product> products = productRepository.getByProductNameStartsWith(productName);
        List<GetByProductResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetByProductResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetByProductResponse>>(productResponses, "Products listed.");
    }

    @Override
    public DataResult<List<GetByProductResponse>> getByNameAndCategory(String productName, int categoryId) {
        List<Product> products = productRepository.getByNameAndCategory(productName, categoryId);
        List<GetByProductResponse> productResponses = products.stream().map(product -> modelMapperService.forResponse().map(product, GetByProductResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetByProductResponse>>(productResponses, "Products listed.");
    }

    @Override
    public DataResult<List<ProductWithCategoryResponse>> getProductWithCategoryResponseDetails() {
        return new SuccessDataResult<List<ProductWithCategoryResponse>>(productRepository.getProductWithCategoryResponseDetails(), "Data listed.");
    }
}
