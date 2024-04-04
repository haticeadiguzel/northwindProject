package com.northwind.northwind.business.concretes;

import com.northwind.northwind.business.abstracts.CategoryService;
import com.northwind.northwind.core.utilities.mappers.ModelMapperService;
import com.northwind.northwind.core.utilities.results.DataResult;
import com.northwind.northwind.core.utilities.results.SuccessDataResult;
import com.northwind.northwind.dataAccess.abstracts.CategoryRepository;
import com.northwind.northwind.entities.concretes.Category;
import com.northwind.northwind.entities.dtos.responses.GetAllCategoriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllCategoriesResponse>> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> categoriesResponses = categories.stream().map(category -> modelMapperService.forResponse().map(category, GetAllCategoriesResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllCategoriesResponse>>(categoriesResponses, "Data listed.");
    }
}
