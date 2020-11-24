package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.IngredientStorage;
import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.springframework.web.bind.annotation.*;

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





}