package com.rtr.api.api.controller;

import com.rtr.api.application.dto.ProductDto;
import mock.MockService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTests {
    private ProductController productController;

    @BeforeAll
    void setup() {
        productController = new ProductController(new MockService());
    }
    @Test
    void getAllProducts_returnsProductDtoIterable() {
        Iterable<ProductDto> productDtos = productController.getAllProducts();
        assertNotNull(productDtos);
        assertEquals("Test ProductDto", ((ArrayList<ProductDto>) productDtos).get(0).getName());
    }

    @Test
    void getProductById_returnsProductDto() {
        ResponseEntity<ProductDto> productDto = productController.getProductById(1);
        assertNotNull(productDto);
        assertEquals(productDto.getStatusCode(), HttpStatus.OK);
        assertEquals("Test ProductDto", productDto.getBody().getName());
    }
}
