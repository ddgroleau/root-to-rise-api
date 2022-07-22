package com.rtr.api.api.controller;

import com.rtr.api.application.event.query.*;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ServiceMediator mediator;
    private final Logger logger;

    public ProductController(@Qualifier("product") ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(ProductController.class);
    }

    @GetMapping("/all")
    public Iterable<ProductDto> getAllProducts() {
        Iterable<ProductDto> productDtos = new ArrayList<ProductDto>();
        try {
            productDtos = (Iterable<ProductDto>) mediator.handleQuery(AllProductsQuery.getInstance());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return productDtos;
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable int productId) {
        try {
            return new ResponseEntity<>((ProductDto) mediator.handleQuery(new ProductByIdQuery(productId)), HttpStatus.OK);
        } catch(NoSuchElementException e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch(Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
