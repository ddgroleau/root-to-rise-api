package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Ingredient;
import com.rtr.api.application.event.query.DistinctIngredientNamesQuery;
import com.rtr.api.application.repository.abstraction.IngredientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IngredientServiceTests {
    private IngredientService ingredientService;
    private final IngredientRepository ingredientRepository = mock(IngredientRepository.class);

    @BeforeAll
    void setup() {
        ingredientService = new IngredientService(ingredientRepository);
    }

    @Test
    void handleQuery_withInvalidParameter_throwsInvalidParameterException() {
        InvalidParameterException exception =
                assertThrows(InvalidParameterException.class,()->ingredientService.handleQuery(null));
        assertEquals("Parameter request does not map to a service method.",exception.getMessage());
    }
    @Test
    void handleQuery_withDistinctIngredientsQuery_ReturnsUniqueIngredientDtos() {
        ArrayList<Ingredient> mockIngredients = new ArrayList<>() {{
            add(new Ingredient(){{
                setIngredientId(1);
                setName("Ingredient1");
            }});
            add(new Ingredient(){{
                setIngredientId(2);
                setName("Ingredient1");
            }});
            add(new Ingredient(){{
                setIngredientId(3);
                setName("Ingredient2");
            }});
        }};
        when(ingredientRepository.findAll()).thenReturn(mockIngredients);

        List<String> names = (List<String>) ingredientService.handleQuery(new DistinctIngredientNamesQuery());
        assertNotNull(names);
        assertEquals(2, names.size());
    }
}
