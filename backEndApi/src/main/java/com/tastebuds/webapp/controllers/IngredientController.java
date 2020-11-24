package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.IngredientStorage;
import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {
    private IngredientStorage ingredientStorage;
    private PairingStorage pairingStorage;

    public IngredientController(IngredientStorage ingredientStorage, PairingStorage pairingStorage) {
        this.ingredientStorage = ingredientStorage;
        this.pairingStorage = pairingStorage;
    }
    @GetMapping ("/api/ingredient/{id}")
    public Ingredient retrieveIngredientById(@PathVariable Long id){
        return ingredientStorage.retrieveIngredientById(id);
    }
    @GetMapping ("/api/pairing/{id}")
    public Pairing retrievePairingById(@PathVariable Long id){
        return pairingStorage.retrievePairingById(id);
    }


}