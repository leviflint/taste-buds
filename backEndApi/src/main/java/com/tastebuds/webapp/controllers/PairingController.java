package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class PairingController {

    private PairingStorage pairingStorage;

    public PairingController(PairingStorage pairingStorage) {
        this.pairingStorage = pairingStorage;
    }

    @GetMapping("/api/pairing/{id}")
    public Pairing retrievePairingById(@PathVariable Long id){
        return pairingStorage.retrievePairingById(id);
    }


    @GetMapping("/api/pairing/{id}/ingredient")
    public Set<Ingredient> retrieveIngredientsAssociatedWithPairing(@PathVariable Long id) {
        Pairing retrievedPairing = pairingStorage.retrievePairingById(id);
        return retrievedPairing.getIngredients();
    }

    @GetMapping("/api/pairings/{pairing}")
    public List<Pairing> retrievePairingsByName(@PathVariable String pairing){
        return pairingStorage.retrieveAllPairingsByName(pairing);
    }


}
