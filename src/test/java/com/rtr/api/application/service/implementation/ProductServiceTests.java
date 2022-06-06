package com.rtr.api.application.service.implementation;

import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.dto.ProductDto;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.dto.TraitDto;
import mock.MockProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductServiceTests {
    private ProductService productService;

    @BeforeAll
    void setup() {
            productService = new ProductService(new MockProductRepository());
    }

    @Test
    void handleQuery_withNullArgument_ReturnsInstanceOfProductsIterable() {
        Iterable<ProductDto> productDtos = (Iterable<ProductDto>) productService.handleQuery(null);
        assertThat(productDtos instanceof  Iterable<ProductDto>);
    }

    @Test
    void handleQuery_withNullArgument_ReturnsProductsWithDtoInstancesForNestedObjects() {
        List<ProductDto> productDtos = (List<ProductDto>) productService.handleQuery(null);
        assertThat(productDtos.get(0).getIngredients() instanceof Set<IngredientDto>);
        assertThat(productDtos.get(0).getTraits() instanceof Set<TraitDto>);
        assertThat(productDtos.get(0).getProperties() instanceof Set<PropertyDto>);
    }

    @Test
    void handleQuery_withNullArgument_ReturnsProductsWithCorrectlyMappedDtos() {
        List<ProductDto> productDtos = (List<ProductDto>) productService.handleQuery(null);
        assertThat(productDtos.get(0).getIngredients().stream().toList().size() == 1);
        assertThat(productDtos.get(0).getIngredients().stream().toList().get(0).getName().equals("Test Ingredient"));
        assertThat(productDtos.get(0).getTraits().stream().toList().size() == 1);
        assertThat(productDtos.get(0).getTraits().stream().toList().get(0).getName().equals("Test Trait"));
        assertThat(productDtos.get(0).getProperties().stream().toList().size() == 1);
        assertThat(productDtos.get(0).getTraits().stream().toList().get(0).getName().equals("Test Property"));
    }
}
