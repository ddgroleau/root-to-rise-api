package com.rtr.api.api.controller;

import com.rtr.api.api.service.abstraction.ServiceBase;
import com.rtr.api.application.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("product")
    private final ServiceBase productService;
    private final Logger logger;

    public ProductController(ServiceBase productService) {
        this.productService = productService;
        this.logger = LoggerFactory.getLogger(ProductController.class);
    }

    @GetMapping("/all")
    public Iterable<ProductDto> getAllProducts() {
        Iterable<ProductDto>  productDtos = new ArrayList<ProductDto>();
        try {
            productDtos = (Iterable<ProductDto>) productService.handleQuery(null);
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return productDtos;
        }
    }

}
