package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.resources.Pairing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
//    @GetMapping("/api/pairing/ingredient/{id}")
//    public Pairing retrievePairingAssociatedWithIngredients(@PathVariable Long id) {
//        Pairing retrievePairing = pairingStorage.retrievePairingById(id);
//       return pairingStorage.showIngredients();
//    }


}
