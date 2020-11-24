package com.tastebuds.webapp;

import com.tastebuds.webapp.Storage.IngredientRepository;
import com.tastebuds.webapp.Storage.IngredientStorage;
import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.Storage.PairingsRepository;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    private IngredientStorage ingredientStorage;
    private PairingStorage pairingStorage;
    private IngredientRepository ingredientRepo;
    private PairingsRepository pairingsRepo;

    public Populator(IngredientStorage ingredientStorage, PairingStorage pairingStorage, IngredientRepository ingredientRepo, PairingsRepository pairingsRepo) {
        this.ingredientStorage = ingredientStorage;
        this.pairingStorage = pairingStorage;
        this.ingredientRepo = ingredientRepo;
        this.pairingsRepo = pairingsRepo;
    }

    @Override
    public void run(String... args) throws Exception{
//        Ingredient chicken = new Ingredient("chicken");
//        ingredientStorage.saveIngredient(chicken);
//        Ingredient salt = new Ingredient("salt");
//        ingredientStorage.saveIngredient(salt);
//        Ingredient pepper = new Ingredient("pepper");
//        ingredientStorage.saveIngredient(pepper);
//        Pairing lemon = new Pairing("lemon", chicken);
//        pairingStorage.savePairing(lemon);
//        Pairing caramel = new Pairing("caramel", salt);
//        pairingStorage.savePairing(caramel);
//        Pairing garlic = new Pairing("garlic", chicken, salt, pepper);
//        pairingStorage.savePairing(garlic);


    }
}
