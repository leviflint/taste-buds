package com.tastebuds.webapp;

import com.tastebuds.webapp.Storage.IngredientRepository;
import com.tastebuds.webapp.Storage.IngredientStorage;
import com.tastebuds.webapp.Storage.PairingStorage;
import com.tastebuds.webapp.Storage.PairingsRepository;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import javassist.compiler.ast.Pair;
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
        Ingredient pork = new Ingredient("pork", "tortilla, cilantro, pineapple", "dough, red sauce, cheese", "fennel, garlic, black pepper");
        ingredientStorage.saveIngredient(pork);
        Ingredient lamb = new Ingredient("lamb", "lettuce, pita, tomatoes", "parsley, mint, rice", "tomato, potato, carrot");
        ingredientStorage.saveIngredient(lamb);
        Ingredient seitan = new Ingredient("seitan", "rice, peppers, sessame oil", "mashed potatoes, gravy, mac n cheese", "flour tortilla, lettuce, black beans");
        ingredientStorage.saveIngredient(seitan);
        Ingredient tofu = new Ingredient("tofu", "general tso's, rice, broccoli", "carrot, zucchini, olive oil", "green onion, barbeque sauce, hash browns");
        ingredientStorage.saveIngredient(tofu);



        Pairing boldLemon = new Pairing("lemon", Pairing.DietaryFilter.SOUR ,1,  chicken, salmon, shrimp);
        pairingStorage.savePairing(boldLemon);
        Pairing normalLemon = new Pairing( "lemon" , Pairing.DietaryFilter.SOUR ,2, steak, pasta);
        pairingStorage.savePairing(normalLemon);
        Pairing italicLemon = new Pairing("lemon",Pairing.DietaryFilter.SOUR ,1, pork, lamb, seitan, tofu);
        pairingStorage.savePairing(italicLemon);


        Pairing boldTeriyakiSauce = new Pairing( "teriyaki sauce", Pairing.DietaryFilter.SALTY ,1, salmon, steak, chicken, seitan,tofu, pork);
        pairingStorage.savePairing(boldTeriyakiSauce);
        Pairing italicTeriyakiSauce = new Pairing("teriyaki sauce", Pairing.DietaryFilter.SALTY,3, eggs, lamb);
        pairingStorage.savePairing(italicTeriyakiSauce);

        Pairing capsGarlic = new Pairing("GARLIC", Pairing.DietaryFilter.SWEET,1, chicken, steak, shrimp, pasta, lamb, tofu);
        pairingStorage.savePairing(capsGarlic);
        Pairing italicGarlic = new Pairing( "garlic", Pairing.DietaryFilter.SWEET,3, pork, seitan);
        pairingStorage.savePairing(italicGarlic);

        Pairing capsOnions = new Pairing("ONIONS", Pairing.DietaryFilter.SWEET,1, chicken, steak, shrimp, pasta, eggs, lamb, seitan, pork, tofu);
        pairingStorage.savePairing(capsOnions);

        Pairing normalCumin = new Pairing("cumin", Pairing.DietaryFilter.SMOKY,2,chicken, steak, pork, lamb, tofu, seitan);
        pairingStorage.savePairing(normalCumin);

        Pairing boldPotatoes = new Pairing("potatoes", Pairing.DietaryFilter.SWEET ,1, chicken, steak, pork, lamb);
        pairingStorage.savePairing(boldPotatoes);
        Pairing capsPotatoes = new Pairing("POTATOES", Pairing.DietaryFilter.SWEET,1, eggs);
        pairingStorage.savePairing(capsPotatoes);

        Pairing capsRosemary = new Pairing("ROSEMARY", Pairing.DietaryFilter.SWEET,1, chicken, steak, pork, lamb );
        pairingStorage.savePairing(capsRosemary);
        Pairing normalRosemary = new Pairing("rosemary", Pairing.DietaryFilter.SWEET,1, pasta, tofu);
        pairingStorage.savePairing(normalRosemary);

        Pairing capsButter = new Pairing("BUTTER", Pairing.DietaryFilter.BLAND,1, salmon, chicken, steak, pork, lamb);
        pairingStorage.savePairing(capsButter);
        Pairing boldButter = new Pairing("butter", Pairing.DietaryFilter.BLAND,1, shrimp, eggs, pasta);
        pairingStorage.savePairing(boldButter);

        Pairing capsTomatoes = new Pairing("TOMATOES", Pairing.DietaryFilter.SWEET,1, chicken, shrimp, pasta, seitan);
        pairingStorage.savePairing(capsTomatoes);
        Pairing normalTomatoes = new Pairing("tomatoes", Pairing.DietaryFilter.SWEET,1, eggs);
        pairingStorage.savePairing(normalTomatoes);
        Pairing boldTomatoes = new Pairing("tomatoes", Pairing.DietaryFilter.SWEET,1, pork, lamb);
        pairingStorage.savePairing(boldTomatoes);

        Pairing capsBasil = new Pairing("BASIL", Pairing.DietaryFilter.SWEET,1, chicken, pasta, tofu);
        pairingStorage.savePairing(capsBasil);
        Pairing italicsBasil = new Pairing("basil", Pairing.DietaryFilter.SWEET,1, eggs, seitan, lamb);
        pairingStorage.savePairing(italicsBasil);

        Pairing capsGinger = new Pairing("GINGER", Pairing.DietaryFilter.SOUR,1, chicken, salmon, pork );
        pairingStorage.savePairing(capsGinger);
        Pairing boldGinger = new Pairing("ginger", Pairing.DietaryFilter.SOUR,1, lamb);
        pairingStorage.savePairing(boldGinger);
        Pairing normalGinger = new Pairing("ginger", Pairing.DietaryFilter.SOUR,1, seitan);
        pairingStorage.savePairing(normalGinger);

        Pairing boldBacon = new Pairing("bacon", Pairing.DietaryFilter.SALTY,1, chicken, shrimp, eggs, pasta);
        pairingStorage.savePairing(boldBacon);
        Pairing normalBacon = new Pairing("bacon", Pairing.DietaryFilter.SALTY,1, lamb);
        pairingStorage.savePairing(normalBacon);

        Pairing capsMushroom = new Pairing("MUSHROOMS", Pairing.DietaryFilter.UMAMI,1, chicken, eggs, pasta, seitan, tofu);
        pairingStorage.savePairing(capsMushroom);
        Pairing boldMushroom = new Pairing("mushrooms",Pairing.DietaryFilter.UMAMI,1, steak, shrimp);
        pairingStorage.savePairing(boldMushroom);
        Pairing normalMushroom = new Pairing("mushroom", Pairing.DietaryFilter.UMAMI,1, lamb, pork);
        pairingStorage.savePairing(normalMushroom);

        Pairing normalRice = new Pairing("rice", Pairing.DietaryFilter.BLAND,2, steak, shrimp, eggs, pork);
        pairingStorage.savePairing(normalRice);
        Pairing boldRice = new Pairing("rice", Pairing.DietaryFilter.BLAND,1, chicken, salmon, lamb, seitan, tofu);
        pairingStorage.savePairing(boldRice);




    }
}
