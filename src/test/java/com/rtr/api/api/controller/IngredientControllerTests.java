package com.rtr.api.api.controller;

import com.rtr.api.application.dto.IngredientDto;
import mock.MockService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IngredientControllerTests {
    private IngredientController ingredientController;

    @BeforeAll
    void setup() {
        ingredientController = new IngredientController(new MockService());
    }

    @Test
    void getDistinctIngredientNames_ReturnsIngredientDtoIterable() {
        Iterable<String> names = ingredientController.getDistinctIngredientNames();
        assertNotNull(names);
        assertEquals("Test IngredientDto",((ArrayList<String>)names).get(0));
    }

}
