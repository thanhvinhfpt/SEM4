package com.example.exam.service.impl;

import com.example.exam.entity.Product;
import com.example.exam.repository.ProductRepository;
import com.example.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String sellProduct(Long productId, int quantity) {
        Product product = productRepository.findById(productId).orElse(null);
        if(product != null && product.getQuantity() >= quantity){
            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            return "sell success";
        }else{
            return "sell error";
        }
    }
}
