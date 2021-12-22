package com.example.demo.controller;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("list/product")
    public String getProduct(Model model){
        model.addAttribute("products", productService.getProducts());
        return "list-product";
    }
}
