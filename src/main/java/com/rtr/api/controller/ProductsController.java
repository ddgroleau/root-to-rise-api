package com.rtr.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @GetMapping("/")
    public String getAllProducts() {
        return "Hello World!";
    }
}
