package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Ingredient;
import org.springframework.stereotype.Service;

@Service
public class IngredientStorage {
    private IngredientRepository ingredientRepo;

    public IngredientStorage(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    public void saveIngredient(Ingredient ingredientToSave) {
        ingredientRepo.save(ingredientToSave);
    }

    public Ingredient retrieveIngredientById(Long id) {
        return ingredientRepo.findById(id).get();
    }

    public Iterable<Ingredient> retrieveAllIngredients() {
        return ingredientRepo.findAll();
    }

    public Ingredient findIngredientByName(String name){
        return ingredientRepo.findByIngredient(name);
    }
}
