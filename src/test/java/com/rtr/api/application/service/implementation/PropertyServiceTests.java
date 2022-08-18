package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Property;
import com.rtr.api.application.event.query.DistinctPropertyNamesQuery;
import com.rtr.api.application.repository.abstraction.PropertyRepository;
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
public class PropertyServiceTests {
    private PropertyService propertyService;
    private final PropertyRepository propertyRepository = mock(PropertyRepository.class);

    @BeforeAll
    void setup() {
        propertyService = new PropertyService(propertyRepository);
    }

    @Test
    void handleQuery_withInvalidParameter_throwsInvalidParameterException() {
        InvalidParameterException exception =
                assertThrows(InvalidParameterException.class,()->propertyService.handleQuery(null));
        assertEquals("Parameter request does not map to a service method.",exception.getMessage());
    }
    @Test
    void handleQuery_withDistinctPropertiesQuery_ReturnsUniquePropertyDtos() {
        ArrayList<Property> mockProperties = new ArrayList<>() {{
            add(new Property(){{
                setPropertyId(1);
                setName("Property1");
            }});
            add(new Property(){{
                setPropertyId(2);
                setName("Property1");
            }});
            add(new Property(){{
                setPropertyId(3);
                setName("Property2");
            }});
        }};
        when(propertyRepository.findAll()).thenReturn(mockProperties);

        List<String> names = (List<String>) propertyService.handleQuery(new DistinctPropertyNamesQuery());
        assertNotNull(names);
        assertEquals(2, names.size());
    }
}
