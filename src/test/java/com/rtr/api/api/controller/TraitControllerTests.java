package com.rtr.api.api.controller;

import com.rtr.api.application.dto.TraitDto;
import mock.MockService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TraitControllerTests {
    private TraitController traitController;

    @BeforeAll
    void setup() {
        traitController = new TraitController(new MockService());
    }

    @Test
    void getDistinctTraitNames_ReturnsTraitDtoIterable() {
        Iterable<String> names = traitController.getDistinctTraitNames();
        assertThat(names instanceof  Iterable<String>);
        assertThat(((ArrayList<String>)names).get(0).equals("Test TraitDto"));
    }
}
