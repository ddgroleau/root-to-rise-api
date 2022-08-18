package com.rtr.api.api.controller;

import com.rtr.api.application.dto.TraitDto;
import com.rtr.api.application.event.query.DistinctIngredientNamesQuery;
import com.rtr.api.application.event.query.DistinctTraitNamesQuery;
import com.rtr.api.application.service.implementation.TraitService;
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
public class TraitControllerTests {
    private TraitService traitService;
    private TraitController traitController;

    @BeforeAll
    void setup() {
        traitService = mock(TraitService.class);
        traitController = new TraitController(traitService);
    }

    @Test
    void getDistinctTraitNames_ReturnsTraitDtoIterable() {
        when(traitService.handleQuery(any(DistinctTraitNamesQuery.class)))
                .thenReturn(new ArrayList<String>(){{add("Test TraitDto");}});

        Iterable<String> names = traitController.getDistinctTraitNames();

        assertNotNull(names);
        assertEquals("Test TraitDto", ((ArrayList<String>) names).get(0));
    }
}
