package com.rtr.api.api.controller;

import com.rtr.api.api.service.abstraction.ServiceBase;
import com.rtr.api.application.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("product")
    private final ServiceBase productService;

    public ProductController(ServiceBase productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Iterable<ProductDto> getAllProducts() {
        return (Iterable<ProductDto>) productService.handleQuery(null);
    }
}
