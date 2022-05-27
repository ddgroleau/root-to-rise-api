package com.rtr.api.api.controller;

import com.rtr.api.application.dto.ProductDto;
import mock.MockService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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
    }
}
