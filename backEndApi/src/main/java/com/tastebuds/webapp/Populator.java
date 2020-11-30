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
        Ingredient chicken = new Ingredient("chicken","garlic, pasta, pesto", "rice, beans, cheese","spinach, strawberry, poppy seed dressing");
        ingredientStorage.saveIngredient(chicken);
        Ingredient salmon = new Ingredient("salmon", "nori, rice, soysauce", "asparagus, potatoes, butter", "lettuce, tomatoes, balsamic vinaigrette");
        ingredientStorage.saveIngredient(salmon);
        Ingredient steak = new Ingredient("steak", "ketchup, cheese whiz, cheetos", "baked potatoes, broccoli, mushrooms", "shrimp, linguine, olive oil");
        ingredientStorage.saveIngredient(steak);
        Ingredient shrimp = new Ingredient("shrimp", "cajun seasoning, heavy cream, penne", "chiles, lime juice, brown sugar", "horseradish, ketchup, lemon");
        ingredientStorage.saveIngredient(shrimp);
        Ingredient pasta = new Ingredient("pasta", "tomatoes, basil, garlic", "Gruyere, parmesan, cheddar","ricotta, tomatoes, cream cheese");
        ingredientStorage.saveIngredient(pasta);
        Ingredient eggs = new Ingredient("eggs", "cheese, bacon, onions","cream, vanilla, sugar","soy sauce, mirin, dashi");
        ingredientStorage.saveIngredient(eggs);



        Pairing boldLemon = new Pairing("lemon", 1,  chicken, salmon, shrimp);
        pairingStorage.savePairing(boldLemon);
        Pairing normalLemon = new Pairing( "lemon",2,  salmon, steak, pasta);
        pairingStorage.savePairing(normalLemon);


        Pairing boldTeriyakiSauce = new Pairing( "teriyaki sauce", 1, salmon, chicken, steak);
        pairingStorage.savePairing(boldTeriyakiSauce);
        Pairing italicTeriyakiSauce = new Pairing("teriyaki sauce",3, eggs);
        pairingStorage.savePairing(italicTeriyakiSauce);

        Pairing capsGarlic = new Pairing("GARLIC", 1, chicken, steak, shrimp, pasta);
        pairingStorage.savePairing(capsGarlic);
        Pairing italicGarlic = new Pairing( "garlic", 3,chicken);
        pairingStorage.savePairing(italicGarlic);

        Pairing capsOnions = new Pairing("ONIONS", 1, chicken, steak, shrimp);
        pairingStorage.savePairing(capsOnions);

        Pairing normalCumin = new Pairing("cumin", 2,chicken, steak);
        pairingStorage.savePairing(normalCumin);

        Pairing boldPotatoes = new Pairing("potatoes", 1, chicken, steak);
        pairingStorage.savePairing(boldPotatoes);

        Pairing capsRosemary = new Pairing("ROSEMARY", 1, chicken, steak);
        pairingStorage.savePairing(capsRosemary);

        Pairing capsButter = new Pairing("BUTTER", 1, salmon, chicken, steak);
        pairingStorage.savePairing(capsButter);
        Pairing boldButter = new Pairing("butter",1, shrimp);
        pairingStorage.savePairing(boldButter);

        Pairing capsTomatoes = new Pairing("TOMATOES", 1, chicken, shrimp);
        pairingStorage.savePairing(capsTomatoes);

        Pairing capsBasil = new Pairing("BASIL", 1, chicken);
        pairingStorage.savePairing(capsBasil);

        Pairing capsGinger = new Pairing("GINGER",1, chicken, salmon);
        pairingStorage.savePairing(capsGinger);

        Pairing boldBacon = new Pairing("bacon",1, chicken, shrimp);
        pairingStorage.savePairing(boldBacon);

        Pairing capsMushroom = new Pairing("MUSHROOMS", 1, chicken);
        pairingStorage.savePairing(capsMushroom);
        Pairing boldMushroom = new Pairing("mushrooms",1, steak, shrimp);
        pairingStorage.savePairing(boldMushroom);

        Pairing normalRice = new Pairing("rice", 2, steak, shrimp);
        pairingStorage.savePairing(normalRice);
        Pairing boldRice = new Pairing("rice", 1, chicken, salmon);
        pairingStorage.savePairing(boldRice);




    }
}
