package com.rtr.api.api.controller;

import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.event.query.DistinctIngredientsByNameQuery;
import com.rtr.api.application.dto.IngredientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final ServiceMediator mediator;
    private final Logger logger;

    public IngredientController(@Qualifier("ingredient") ServiceMediator mediator) {
        this.mediator = mediator;
        this.logger = LoggerFactory.getLogger(IngredientController.class);
    }

    @GetMapping("/names/distinct")
    public Iterable<IngredientDto> getDistinctIngredientsByName() {
        Iterable<IngredientDto> ingredientDtos = new ArrayList<IngredientDto>();
        try {
            ingredientDtos = (Iterable<IngredientDto>) mediator.handleQuery(DistinctIngredientsByNameQuery.getInstance());
        } catch(Exception e) {
            logger.error(e.getMessage());
        } finally {
            return ingredientDtos;
        }
    }

}
