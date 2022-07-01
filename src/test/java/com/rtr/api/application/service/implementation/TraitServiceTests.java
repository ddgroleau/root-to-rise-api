package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Trait;
import com.rtr.api.application.dto.TraitDto;
import com.rtr.api.application.event.query.DistinctTraitsByNameQuery;
import com.rtr.api.application.repository.abstraction.TraitRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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
public class TraitServiceTests {
    private TraitService traitService;
    private final TraitRepository traitRepository = mock(TraitRepository.class);

    @BeforeAll
    void setup() {
        traitService = new TraitService(traitRepository);
    }

    @Test
    void handleQuery_withInvalidParameter_throwsInvalidParameterException() {
        InvalidParameterException exception =
                assertThrows(InvalidParameterException.class,()->traitService.handleQuery(null));
        assertThat(exception.getMessage().equals("Parameter request does not map to a service method."));
    }
    @Test
    void handleQuery_withDistinctTraitsQuery_ReturnsUniqueTraitDtos() {
        ArrayList<Trait> mockTraits = new ArrayList<>() {{
            add(new Trait(){{
                setTraitId(1);
                setName("Trait1");
            }});
            add(new Trait(){{
                setTraitId(2);
                setName("Trait1");
            }});
            add(new Trait(){{
                setTraitId(3);
                setName("Trait2");
            }});
            add(new Trait(){{
                setTraitId(4);
                setName("Trait3");
            }});
        }};
        when(traitRepository.findAll()).thenReturn(mockTraits);

        List<TraitDto> traitDtos = (List<TraitDto>) traitService.handleQuery(new DistinctTraitsByNameQuery());
        assertThat(traitDtos instanceof  Iterable<TraitDto>);
        assertTrue(traitDtos.size() == 3);
    }
}
