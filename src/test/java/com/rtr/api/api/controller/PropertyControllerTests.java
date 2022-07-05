package com.rtr.api.api.controller;

import com.rtr.api.application.dto.PropertyDto;
import mock.MockService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropertyControllerTests {
    private PropertyController propertyController;

    @BeforeAll
    void setup() {
        propertyController = new PropertyController(new MockService());
    }

    @Test
    void getDistinctPropertyNames_ReturnsPropertyDtoIterable() {
        Iterable<String> names = propertyController.getDistinctPropertyNames();
        assertNotNull(names);
        assertEquals("Test PropertyDto", ((ArrayList<String>) names).get(0));
    }

}
