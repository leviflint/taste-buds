package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.IngredientStorage;
import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.Storage.PairingsRepository;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.management.Query;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class PairingController {


    private PairingStorage pairingStorage;
    private IngredientStorage ingredientStorage;
    private PairingsRepository pairingRepo;

    public PairingController(PairingStorage pairingStorage, IngredientStorage ingredientStorage, PairingsRepository pairingRepo) {
        this.pairingStorage = pairingStorage;
        this.ingredientStorage = ingredientStorage;
        this.pairingRepo = pairingRepo;
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

    @GetMapping("/api/pairings/{pairing}/ingredient")
    public Iterable<Ingredient> retrieveIngredientsAssociatedWithPairingByName(@PathVariable String pairing){
//       Pairing retrievedPairing = pairingStorage.retrievePairingByName(pairing);
//       retrievedPairing.getName().equalsIgnoreCase(pairing);
//        retrievedPairing.getName().compareTo(pairing)
       return pairingStorage.retrieveIngredientsByPairingsName(pairing);
    }


//return ingredient.getPairings()
//        .stream()
//                .filter(pairing -> pairing.getDietaryFilter().equals(filter))
//            .collect(Collectors.toList());
}
