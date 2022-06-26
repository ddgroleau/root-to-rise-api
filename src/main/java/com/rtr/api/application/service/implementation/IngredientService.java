package com.rtr.api.application.service.implementation;

import com.rtr.api.application.service.abstraction.ServiceMediator;
import com.rtr.api.application.domain.model.Ingredient;
import com.rtr.api.application.event.command.Command;
import com.rtr.api.application.event.query.AllIngredientsQuery;
import com.rtr.api.application.dto.IngredientDto;
import com.rtr.api.application.event.query.Query;
import com.rtr.api.application.repository.abstraction.IngredientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.ArrayList;

@Service("ingredient")
public class IngredientService implements ServiceMediator {
    private final IngredientRepository ingredientRepository;
    private final ModelMapper modelMapper;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        this.ingredientRepository = ingredientRepository;
    }

    public Object handleQuery(Query query) {
        if(query instanceof AllIngredientsQuery) return this.getAllIngredients();
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }

    public void handleCommand(Command command) {
        throw new InvalidParameterException("Parameter request does not map to a service method.");
    }
    private Iterable<IngredientDto> getAllIngredients() {
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();
        ArrayList<IngredientDto> ingredientDtos = new ArrayList<IngredientDto>();
        for (Ingredient ingredient: ingredients) {
            IngredientDto ingredientDto = modelMapper.map(ingredient,IngredientDto.class);
            ingredientDtos.add(ingredientDto);
        }
        return ingredientDtos;
    }
}
