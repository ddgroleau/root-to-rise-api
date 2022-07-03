package com.rtr.api.application.service.implementation;

import com.rtr.api.application.domain.model.Ingredient;
import com.rtr.api.application.domain.model.Product;
import com.rtr.api.application.domain.model.Property;
import com.rtr.api.application.domain.model.Trait;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.event.query.ProductByIdQuery;
import com.rtr.api.application.repository.abstraction.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        assertEquals("Parameter request does not map to a service method.", exception.getMessage());
    }
    @Test
    void handleQuery_withAllProductsQuery_returnsProductDtos() {
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
        assertNotNull(productDtos);
        assertNotNull(productDtos.get(0).getIngredients());
        assertNotNull(productDtos.get(0).getTraits());
        assertNotNull(productDtos.get(0).getProperties());
        assertEquals("Test Ingredient", productDtos.get(0).getIngredients().stream().toList().get(0).getName());
        assertEquals("Test Trait", productDtos.get(0).getTraits().stream().toList().get(0).getName());
        assertEquals("Test Property", productDtos.get(0).getProperties().stream().toList().get(0).getName());
    }

    @Test
    void handleQuery_withProductByIdQuery_returnsProductDto() {
        int testId = 1;
        String testName = "Test Product";
        when(productRepository.findById(testId)).thenReturn(Optional.of(new Product(){{
            setName(testName);
            setProductId(testId);
        }}));

        ProductDto productDto = (ProductDto) productService.handleQuery(new ProductByIdQuery(testId));
        assertEquals(productDto.getName(), testName);
        assertEquals((int) productDto.getProductId(), testId);
    }

    @Test
    void handleQuery_withProductByIdQuery_throwsIfNoMatch() {
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        NoSuchElementException exception =
                assertThrows(NoSuchElementException.class,()-> productService.handleQuery(new ProductByIdQuery(1)));
        assertEquals("Could not find element with ID: 1.", exception.getMessage());
    }

    @Test
    void handleQuery_withProductByIdQuery_throwsIfInvalidProductId() {
        InvalidParameterException exception =
                assertThrows(InvalidParameterException.class,()-> productService.handleQuery(new ProductByIdQuery(0)));
        assertEquals("Invalid product ID.", exception.getMessage());
    }
}
