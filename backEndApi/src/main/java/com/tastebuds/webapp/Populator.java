package com.tastebuds.webapp;

import com.tastebuds.webapp.Storage.IngredientRepository;
import com.tastebuds.webapp.Storage.IngredientStorage;
import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.Storage.PairingsRepository;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import com.tastebuds.webapp.resources.PairingClass;
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
        Ingredient chicken = new Ingredient("chicken","garlic, pasta, pesto", "rice, beans, cheese","spinach, strawberry, poppy seed dressing");
        ingredientStorage.saveIngredient(chicken);
        Ingredient salmon = new Ingredient("salmon", "nori, rice, soysauce", "asparagus, potatoes, butter", "lettuce, tomatoes, balsamic vinaigrette");
        ingredientStorage.saveIngredient(salmon);
        Ingredient steak = new Ingredient("steak", "ketchup, cheese whiz, cheetos", "baked potatoes, broccoli, mushrooms", "shrimp, linguine, olive oil");
        ingredientStorage.saveIngredient(steak);

        PairingClass lemon = new PairingClass("lemon");
        Pairing boldLemon = new Pairing(lemon, "Lemon", 1,  chicken);
        pairingStorage.savePairing(boldLemon);
        Pairing normalLemon = new Pairing(lemon, "lemon",3,  salmon);
        pairingStorage.savePairing(normalLemon);

        PairingClass teriyakiSauce = new PairingClass("teriyaki sauce");
        Pairing boldTeriyakiSauce = new Pairing(teriyakiSauce, "teriyaki sauce", 1, salmon, chicken, steak);
        pairingStorage.savePairing(boldTeriyakiSauce);

        PairingClass garlic = new PairingClass("garlic");
        Pairing italicGarlic = new Pairing(garlic, "garlic", 4,chicken, salmon, steak);
        pairingStorage.savePairing(italicGarlic);
    }
}
