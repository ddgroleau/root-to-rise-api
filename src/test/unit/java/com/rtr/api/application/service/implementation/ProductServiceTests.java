package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Ingredient;
import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.domain.model.Property;
import com.rtr.api.application.domain.model.Trait;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.dto.TraitDto;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductServiceTests {
    private ProductService productService;
    private final ProductRepository productRepository = mock(ProductRepository.class);

    @BeforeAll
    void setup() {
        productService = new ProductService(productRepository);
    }

    @Test
    void handleQuery_withInvalidParameter_throwsInvalidParameterException() {
        InvalidParameterException exception =
                assertThrows(InvalidParameterException.class,()->productService.handleQuery(null));
        assertThat(exception.getMessage().equals("Parameter request does not map to a service method."));
    }
    @Test
    void handleQuery_withAllProductsQuery_ReturnsProductDtos() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>() {{
            add(new Product() {{
                setIngredients(new HashSet<>(){{
                    add(new Ingredient(){{setName("Test Ingredient");}});
                }});
                setProperties(new HashSet<>() {{
                    add(new Property() {{
                        setName("Test Property");
                    }});
                }});
                setTraits(new HashSet<>(){{
                    add(new Trait(){{setName("Test Trait");}});
                }});
            }});
        }});

        ArrayList<ProductDto> productDtos = (ArrayList<ProductDto>) productService.handleQuery(new AllProductsQuery());
        assertThat(productDtos instanceof  Iterable<ProductDto>);
        assertThat(productDtos.get(0).getIngredients() instanceof Set<IngredientDto>);
        assertThat(productDtos.get(0).getTraits() instanceof Set<TraitDto>);
        assertThat(productDtos.get(0).getProperties() instanceof Set<PropertyDto>);
        assertThat(productDtos.get(0).getIngredients().stream().toList().get(0).getName().equals("Test Ingredient"));
        assertThat(productDtos.get(0).getTraits().stream().toList().get(0).getName().equals("Test Trait"));
        assertThat(productDtos.get(0).getTraits().stream().toList().get(0).getName().equals("Test Property"));
    }

}
