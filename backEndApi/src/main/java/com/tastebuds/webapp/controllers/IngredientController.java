package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.IngredientStorage;
import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class IngredientController {
    private IngredientStorage ingredientStorage;
    private PairingStorage pairingStorage;

    public IngredientController(IngredientStorage ingredientStorage, PairingStorage pairingStorage) {
        this.ingredientStorage = ingredientStorage;
        this.pairingStorage = pairingStorage;
    }
    @GetMapping("/api/ingredients")
    public Iterable<Ingredient> retrieveAllIngredients(){
       return ingredientStorage.retrieveAllIngredients();
    }


    @GetMapping("/api/ingredient/{id}")
    public Ingredient retrieveIngredientById(@PathVariable Long id){
        return ingredientStorage.retrieveIngredientById(id);
    }

    @PostMapping("/api/ingredient")
    public Iterable<Ingredient> addIngredient(@RequestBody Ingredient ingredientToAdd){
        ingredientStorage.saveIngredient(ingredientToAdd);
        return ingredientStorage.retrieveAllIngredients();
    }

    @GetMapping("/api/ingredient-name/{name}")
    public Ingredient retrieveIngredientByName(@PathVariable String name) {
        return ingredientStorage.findIngredientByName(name);
    }
    @GetMapping("/api/ingredient/{id}/pairing/dietaryFilter")
    public List<Pairing> retrievePairingWithDietaryFilter(@RequestParam Pairing.DietaryFilter filter, @PathVariable Long id){
        Ingredient ingredient = ingredientStorage.retrieveIngredientById(id);

        return ingredient.getPairings()
                .stream()
                .filter(pairing -> pairing.getDietaryFilter().equals(filter))
                .collect(Collectors.toList());
    }

}