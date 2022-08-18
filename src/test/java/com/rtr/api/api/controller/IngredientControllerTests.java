package com.rtr.api.api.controller;

import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.event.query.DistinctIngredientNamesQuery;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.service.implementation.IngredientService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IngredientControllerTests {
    private IngredientService ingredientService;
    private IngredientController ingredientController;

    @BeforeAll
    void setup() {
        ingredientService = mock(IngredientService.class);
        ingredientController = new IngredientController(ingredientService);
    }

    @Test
    void getDistinctIngredientNames_ReturnsIngredientDtoIterable() {
        when(ingredientService.handleQuery(any(DistinctIngredientNamesQuery.class)))
                .thenReturn(new ArrayList<String>(){{add("Test IngredientDto");}});

        Iterable<String> names = ingredientController.getDistinctIngredientNames();

        assertNotNull(names);
        assertEquals("Test IngredientDto",((ArrayList<String>)names).get(0));
    }

}
