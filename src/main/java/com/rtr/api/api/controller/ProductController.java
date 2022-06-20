package com.rtr.api.api.controller;

import com.rtr.api.application.dto.request.AllIngredientsQuery;
import com.rtr.api.application.dto.request.AllProductsQuery;
import com.rtr.api.application.dto.request.AllPropertiesQuery;
import com.rtr.api.application.dto.request.AllTraitsQuery;
import com.rtr.api.application.dto.response.PropertyDto;
import com.rtr.api.application.dto.response.TraitDto;
import com.rtr.api.api.service.abstraction.ServiceMediator;
import com.rtr.api.application.dto.response.IngredientDto;
import com.rtr.api.application.dto.response.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Qualifier("product")
    private final ServiceMediator mediator;
    private final Logger logger;

    public ProductController(ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(ProductController.class);
    }

    @GetMapping("/all")
    public Iterable<ProductDto> getAllProducts() {
        Iterable<ProductDto> productDtos = new ArrayList<ProductDto>();
        try {
            productDtos = (Iterable<ProductDto>) mediator.handleQuery(new AllProductsQuery());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return productDtos;
        }
    }

    @GetMapping("/ingredients")
    public Iterable<IngredientDto> getAllIngredients() {
        Iterable<IngredientDto> ingredientDtos = new ArrayList<IngredientDto>();
        try {
            ingredientDtos = (Iterable<IngredientDto>) mediator.handleQuery(new AllIngredientsQuery());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return ingredientDtos;
        }
    }

    @GetMapping("/properties")
    public Iterable<PropertyDto> getAllProperties() {
        Iterable<PropertyDto> propertyDtos = new ArrayList<PropertyDto>();
        try {
            propertyDtos = (Iterable<PropertyDto>) mediator.handleQuery(new AllPropertiesQuery());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return propertyDtos;
        }
    }

    @GetMapping("/traits")
    public Iterable<TraitDto> getAllTraits() {
        Iterable<TraitDto> traitDtos = new ArrayList<TraitDto>();
        try {
            traitDtos = (Iterable<TraitDto>) mediator.handleQuery(new AllTraitsQuery());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return traitDtos;
        }
    }

}
