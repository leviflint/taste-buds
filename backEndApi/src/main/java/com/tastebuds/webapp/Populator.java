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
        Ingredient chicken = new Ingredient("chicken","garlic, pasta, pesto", "https://tinyurl.com/y2medmvg", "https://tinyurl.com/y58d5mgj", "rice, beans, cheese", "https://tinyurl.com/yxfov8cu", "https://tinyurl.com/y3lh3uyd", "spinach, strawberry, poppy seed dressing", "https://tinyurl.com/yywdbdg2", "https://tinyurl.com/yyu3a2rf");
        ingredientStorage.saveIngredient(chicken);
        Ingredient salmon = new Ingredient("salmon", "nori, rice, soysauce", "https://tinyurl.com/y2wj32vv", "https://tinyurl.com/y4rzgk5u", "asparagus, potatoes, butter", "https://tinyurl.com/y4qacr9x", "https://tinyurl.com/y6ft6bps", "lettuce, tomatoes, balsamic vinaigrette", "https://tinyurl.com/y594v45u", "https://tinyurl.com/yyvdl8we");
        ingredientStorage.saveIngredient(salmon);
        Ingredient steak = new Ingredient("steak", "butter, garlic, thyme", "https://tinyurl.com/y68sskcz", "https://tinyurl.com/yx9kftwf",  "baked potatoes, broccoli, mushrooms", "https://tinyurl.com/y4yeorzx", "https://tinyurl.com/y3x8hgyb", "shrimp, linguine, olive oil", "https://tinyurl.com/y3od6xll", "https://tinyurl.com/yygnmyfa");
        ingredientStorage.saveIngredient(steak);
        Ingredient shrimp = new Ingredient("shrimp", "cajun seasoning, heavy cream, penne", "https://tinyurl.com/y5ujrtoz", "https://tinyurl.com/y3szxb9j", "chiles, lime juice, brown sugar", "https://tinyurl.com/y29nwouw", "https://tinyurl.com/yxvsj2sc", "horseradish, ketchup, lemon", "https://tinyurl.com/y5oy7874", "https://tinyurl.com/y3btumwp");
        ingredientStorage.saveIngredient(shrimp);
        Ingredient pasta = new Ingredient("pasta", "tomatoes, basil, garlic", "https://tinyurl.com/y33gxksz", "https://tinyurl.com/yykpznzf", "Gruyere, parmesan, cheddar", "https://tinyurl.com/y667noz4", "https://tinyurl.com/y5vnycks", "ricotta, tomatoes, cream cheese", "https://tinyurl.com/y2tvvyce", "https://tinyurl.com/y5nt9v6h");
        ingredientStorage.saveIngredient(pasta);
        Ingredient eggs = new Ingredient("eggs", "cheese, bacon, onions", "https://tinyurl.com/y365z36f", "https://tinyurl.com/yyxa57r6", "cream, vanilla, sugar", "https://tinyurl.com/y35xwxqm", "https://tinyurl.com/y43nvqgh", "soy sauce, mirin, dashi", "https://tinyurl.com/y46wk83f", "https://tinyurl.com/y483a4k7");
        ingredientStorage.saveIngredient(eggs);
        Ingredient pork = new Ingredient("pork", "tortilla, cilantro, pineapple", "https://tinyurl.com/y2kse3lx", "https://tinyurl.com/yxbfao4o", "dough, red sauce, cheese", "https://tinyurl.com/y5jfhhmp", "https://tinyurl.com/y3murmfy", "fennel, garlic, black pepper", "https://tinyurl.com/y2f2xcfa", "https://tinyurl.com/yyu74nj4");
        ingredientStorage.saveIngredient(pork);
        Ingredient lamb = new Ingredient("lamb", "lettuce, pita, tomatoes", "https://tinyurl.com/y6nc95p8", "https://tinyurl.com/y6pcjhoh", "parsley, mint, rice", "https://tinyurl.com/yyczmjzu", "https://tinyurl.com/y4rxaw87", "tomato, potato, carrot", "https://tinyurl.com/y4mzx5dq", "https://tinyurl.com/y2ck77au");
        ingredientStorage.saveIngredient(lamb);
        Ingredient seitan = new Ingredient("seitan", "rice, peppers, sessame oil", "https://tinyurl.com/y5fsnno2", "https://tinyurl.com/yyjc56lo", "mashed potatoes, gravy, mac n cheese", "https://tinyurl.com/y52kyh92", "https://tinyurl.com/yyemexne", "flour tortilla, lettuce, black beans", "https://tinyurl.com/y522kvds", "https://tinyurl.com/y2xfxklu");
        ingredientStorage.saveIngredient(seitan);
        Ingredient tofu = new Ingredient("tofu", "general tso's, rice, broccoli", "https://tinyurl.com/ydhqxj44", "https://tinyurl.com/y5udk5mp", "carrot, zucchini, olive oil", "https://tinyurl.com/y3oxhont", "https://tinyurl.com/yxlh7rd3", "green onion, barbeque sauce, hash browns", "https://tinyurl.com/yyzdz2nd", "https://tinyurl.com/yyzaxc69");
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
