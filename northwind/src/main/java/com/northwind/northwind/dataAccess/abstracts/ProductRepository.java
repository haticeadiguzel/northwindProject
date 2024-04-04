package com.northwind.northwind.dataAccess.abstracts;

import com.northwind.northwind.entities.concretes.Product;
import com.northwind.northwind.entities.dtos.ProductWithCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategoryId(String productName, int categoryId);

    List<Product> getByCategoryIdIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    //JPQL
    //:, ? gibi ifadeler parametredir.
    @Query("SELECT p FROM Product p WHERE p.productName = :productName AND p.category.id = :categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    @Query("SELECT new com.northwind.northwind.entities.dtos.ProductWithCategoryResponse(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryResponse> getProductWithCategoryResponseDetails();
}
