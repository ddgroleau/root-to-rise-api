package com.rtr.api.api.controller;

import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.event.query.DistinctIngredientNamesQuery;
import com.rtr.api.application.event.query.ProductByIdQuery;
import com.rtr.api.application.service.implementation.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductControllerTests {
    private ProductService productService;
    private ProductController productController;

    @BeforeAll
    void setup() {
        productService = mock(ProductService.class);
        productController = new ProductController(productService);
    }
    @Test
    void getAllProducts_returnsProductDtoIterable() {
        when(productService.handleQuery(any(AllProductsQuery.class)))
                .thenReturn(new ArrayList<ProductDto>(){{add(new ProductDto(){{setName("Test ProductDto");}});}});

        Iterable<ProductDto> productDtos = productController.getAllProducts();

        assertNotNull(productDtos);
        assertEquals("Test ProductDto", ((ArrayList<ProductDto>) productDtos).get(0).getName());
    }

    @Test
    void getProductById_returnsProductDto() {
        when(productService.handleQuery(any(ProductByIdQuery.class)))
                .thenReturn(new ProductDto(){{setName("Test ProductDto");}});

        ResponseEntity<ProductDto> productDto = productController.getProductById(1);

        assertNotNull(productDto);
        assertEquals(productDto.getStatusCode(), HttpStatus.OK);
        assertEquals("Test ProductDto", productDto.getBody().getName());
    }
}
