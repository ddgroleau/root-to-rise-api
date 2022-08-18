package com.rtr.api.api.controller;

import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.event.query.DistinctIngredientNamesQuery;
import com.rtr.api.application.event.query.DistinctPropertyNamesQuery;
import com.rtr.api.application.service.implementation.PropertyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropertyControllerTests {
    private PropertyService propertyService;
    private PropertyController propertyController;

    @BeforeAll
    void setup() {
        propertyService = mock(PropertyService.class);
        propertyController = new PropertyController(propertyService);
    }

    @Test
    void getDistinctPropertyNames_ReturnsPropertyDtoIterable() {
        when(propertyService.handleQuery(any(DistinctPropertyNamesQuery.class)))
                .thenReturn(new ArrayList<String>(){{add("Test PropertyDto");}});

        Iterable<String> names = propertyController.getDistinctPropertyNames();

        assertNotNull(names);
        assertEquals("Test PropertyDto", ((ArrayList<String>) names).get(0));
    }

}
