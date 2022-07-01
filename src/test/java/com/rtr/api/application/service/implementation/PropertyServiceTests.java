package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Property;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.event.query.DistinctPropertiesByNameQuery;
import com.rtr.api.application.repository.abstraction.PropertyRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
        assertThat(exception.getMessage().equals("Parameter request does not map to a service method."));
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

        List<PropertyDto> propertyDtos = (List<PropertyDto>) propertyService.handleQuery(new DistinctPropertiesByNameQuery());
        assertThat(propertyDtos instanceof  Iterable<PropertyDto>);
        assertTrue(propertyDtos.size() == 2);
    }
}
