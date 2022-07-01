package com.rtr.api.api.controller;

import com.rtr.api.application.dto.ProductDto;
import mock.MockService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTests {

    private ProductController productController;

    @BeforeAll
    void setup() {
        productController = new ProductController(new MockService());
    }
    @Test
    void getAllProducts_ReturnsProductDtoIterable() {
        Iterable<ProductDto> productDtos = productController.getAllProducts();
        assertThat(productDtos instanceof  Iterable<ProductDto>);
        assertThat(((ArrayList<ProductDto>)productDtos).get(0).getName().equals("Test ProductDto"));
    }
}
