package com.example.exam.service;

import com.example.exam.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product addProduct(Product product);
    String sellProduct(Long productId, int quantity);
}
