package com.rtr.api.api.controller;

import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.dto.TraitDto;
import mock.MockProductService;
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
        productController = new ProductController(new MockProductService());
    }
    @Test
    void getAllProducts_ReturnsProductDtoIterable() {
        Iterable<ProductDto> productDtos = productController.getAllProducts();
        assertThat(productDtos instanceof  Iterable<ProductDto>);
        assertThat(((ArrayList<ProductDto>)productDtos).get(0).getName().equals("Test ProductDto"));
    }

    @Test
    void getAllIngredients_ReturnsIngredientDtoIterable() {
        Iterable<IngredientDto> ingredientDtos = productController.getAllIngredients();
        assertThat(ingredientDtos instanceof  Iterable<IngredientDto>);
        assertThat(((ArrayList<IngredientDto>)ingredientDtos).get(0).getName().equals("Test IngredientDto"));
    }

    @Test
    void getAllProperties_ReturnsPropertyDtoIterable() {
        Iterable<PropertyDto> propertyDtos = productController.getAllProperties();
        assertThat(propertyDtos instanceof  Iterable<PropertyDto>);
        assertThat(((ArrayList<PropertyDto>)propertyDtos).get(0).getName().equals("Test PropertyDto"));
    }

    @Test
    void getAllTraits_ReturnsTraitDtoIterable() {
        Iterable<TraitDto> traitDtos = productController.getAllTraits();
        assertThat(traitDtos instanceof  Iterable<TraitDto>);
        assertThat(((ArrayList<TraitDto>)traitDtos).get(0).getName().equals("Test TraitDto"));
    }


}
