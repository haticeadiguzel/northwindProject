package com.northwind.northwind.business.concretes;

import com.northwind.northwind.business.abstracts.ProductService;
import com.northwind.northwind.dataAccess.abstracts.ProductRepository;
import com.northwind.northwind.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
