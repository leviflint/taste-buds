package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
