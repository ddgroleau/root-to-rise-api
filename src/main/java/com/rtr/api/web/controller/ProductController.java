package com.rtr.api.web.controller;

import com.rtr.api.application.service.implementation.ProductService;
import com.rtr.api.application.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Iterable<ProductDto> getAllProducts() {
        return (Iterable<ProductDto>) productService.handleQuery(null);
    }
}
