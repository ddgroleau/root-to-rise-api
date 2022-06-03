package com.rtr.api.application.repository.abstraction;

import com.rtr.api.application.domain.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
