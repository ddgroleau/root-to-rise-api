package com.rtr.api.api.controller;

import com.rtr.api.application.event.query.DistinctIngredientsByNameQuery;
import com.rtr.api.application.event.query.AllProductsQuery;
import com.rtr.api.application.event.query.DistinctPropertiesByNameQuery;
import com.rtr.api.application.event.query.DistinctTraitsByNameQuery;
import com.rtr.api.application.dto.PropertyDto;
import com.rtr.api.application.dto.TraitDto;
import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.dto.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ServiceMediator mediator;
    private final Logger logger;

    public ProductController(@Qualifier("product") ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(ProductController.class);
    }

    @GetMapping("/all")
    public Iterable<ProductDto> getAllProducts() {
        Iterable<ProductDto> productDtos = new ArrayList<ProductDto>();
        try {
            productDtos = (Iterable<ProductDto>) mediator.handleQuery(AllProductsQuery.getInstance());
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
            ingredientDtos = (Iterable<IngredientDto>) mediator.handleQuery(new DistinctIngredientsByNameQuery());
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
            propertyDtos = (Iterable<PropertyDto>) mediator.handleQuery(new DistinctPropertiesByNameQuery());
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
            traitDtos = (Iterable<TraitDto>) mediator.handleQuery(new DistinctTraitsByNameQuery());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return traitDtos;
        }
    }

}
