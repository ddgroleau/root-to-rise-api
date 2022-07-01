package com.rtr.api.api.controller;

import com.rtr.api.application.dto.PropertyDto;
import mock.MockService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PropertyControllerTests {
    private PropertyController propertyController;

    @BeforeAll
    void setup() {
        propertyController = new PropertyController(new MockService());
    }

    @Test
    void getDistinctPropertiesByName_ReturnsPropertyDtoIterable() {
        Iterable<PropertyDto> propertyDtos = propertyController.getDistinctPropertiesByName();
        assertThat(propertyDtos instanceof  Iterable<PropertyDto>);
        assertThat(((ArrayList<PropertyDto>)propertyDtos).get(0).getName().equals("Test PropertyDto"));
    }

}
