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
        Ingredient chicken = new Ingredient("chicken","garlic,\n pasta,\n basil", "https://tinyurl.com/y2medmvg", "https://tinyurl.com/y58d5mgj", "rice,\n red beans,\n andouille sausage", "https://cooking.nytimes.com/recipes/1014363-spicy-red-beans-with-chicken-and-andouille-sausage", "https://static01.nyt.com/images/2012/11/28/dining/28BEANS6/28BEANS6-articleLarge-v3.jpg", "apples,\n endive,\n walnuts", "https://food52.com/recipes/15552-sage-roasted-chicken-with-endive-salad", "https://images.food52.com/WFwWUzvJGp0bQAz4eiVpINsYKo0=/1008x672/filters:format(webp)/115d1409-acbc-409b-81d6-79ac05402386--DSC_1837.jpg");
        ingredientStorage.saveIngredient(chicken);
        Ingredient salmon = new Ingredient("salmon", "nori,\n rice,\n soy sauce", "https://tinyurl.com/y2wj32vv", "https://tinyurl.com/y4rzgk5u", "asparagus,\n potatoes,\n butter", "https://tinyurl.com/y4qacr9x", "https://tinyurl.com/y6ft6bps", "cilantro,\n scallion,\n serrano pepper", "https://tinyurl.com/y594v45u", "https://tinyurl.com/yyvdl8we");
        ingredientStorage.saveIngredient(salmon);
        Ingredient steak = new Ingredient("steak", "butter,\n garlic,\n thyme", "https://tinyurl.com/y68sskcz", "https://tinyurl.com/yx9kftwf",  "potatoes,\n red wine,\n rosemary", "https://www.jessicagavin.com/ribeye-steaks-red-wine-sauce/", "https://www.jessicagavin.com/wp-content/uploads/2018/06/ribeye-steak-with-red-wine-sauce-6-600x900.jpg", "shrimp,\n pasta,\n olive oil", "https://tinyurl.com/y3od6xll", "https://tinyurl.com/yygnmyfa");
        ingredientStorage.saveIngredient(steak);
        Ingredient shrimp = new Ingredient("shrimp", "oregano,\n paprika,\n cayenne pepper", "https://tinyurl.com/y5ujrtoz", "https://tinyurl.com/y3szxb9j", "chiles,\n lime juice,\n brown sugar", "https://tinyurl.com/y29nwouw", "https://tinyurl.com/yxvsj2sc", "horseradish,\n ketchup,\n lemon", "https://tinyurl.com/y5oy7874", "https://tinyurl.com/y3btumwp");
        ingredientStorage.saveIngredient(shrimp);
        Ingredient pasta = new Ingredient("pasta", "tomatoes,\n basil,\n garlic", "https://tinyurl.com/y33gxksz", "https://tinyurl.com/yykpznzf", "Gruyere,\n parmesan,\n cheddar", "https://tinyurl.com/y667noz4", "https://tinyurl.com/y5vnycks", "ricotta,\n tomatoes,\n cream cheese", "https://tinyurl.com/y2tvvyce", "https://tinyurl.com/y5nt9v6h");
        ingredientStorage.saveIngredient(pasta);
        Ingredient eggs = new Ingredient("eggs", "cheese,\n bacon,\n onions", "https://tinyurl.com/y365z36f", "https://tinyurl.com/yyxa57r6", "cream,\n vanilla,\n sugar", "https://tinyurl.com/y35xwxqm", "https://tinyurl.com/y43nvqgh", "soy sauce,\n mirin,\n dashi", "https://tinyurl.com/y46wk83f", "https://tinyurl.com/y483a4k7");
        ingredientStorage.saveIngredient(eggs);
        Ingredient pork = new Ingredient("pork", "apple juice,\n chile pepper,\n pineapple", "https://tinyurl.com/y2kse3lx", "https://tinyurl.com/yxbfao4o", "mushroom,\n tomato,\n oregano", "https://tinyurl.com/y5jfhhmp", "https://tinyurl.com/y3murmfy", "fennel,\n garlic,\n black pepper", "https://tinyurl.com/y2f2xcfa", "https://tinyurl.com/yyu74nj4");
        ingredientStorage.saveIngredient(pork);
        Ingredient lamb = new Ingredient("lamb", "marjoram,\n rosemary,\n tomatoes", "https://tinyurl.com/y6nc95p8", "https://tinyurl.com/y6pcjhoh", "parsley,\n mint,\n rice", "https://tinyurl.com/yyczmjzu", "https://tinyurl.com/y4rxaw87", "tomato,\n peas,\n rosemary", "https://www.foodnetwork.com/recipes/alton-brown/shepherds-pie-recipe2-1942900", "https://tinyurl.com/y2ck77au");
        ingredientStorage.saveIngredient(lamb);
        Ingredient seitan = new Ingredient("seitan", "brown sugar,\n cayenne pepper,\n paprika", "https://www.veganosity.com/the-best-vegan-nashville-hot-chicken/", "https://www.veganosity.com/wp-content/uploads/2019/08/Nashville-Chickn-Sandwich-9.jpg", "cumin,\n coriander,\n curry powder", "https://tinyurl.com/y52kyh92", "https://tinyurl.com/yyemexne", "cilantro,\n cumin,\n mushrooms", "https://tinyurl.com/y522kvds", "https://tinyurl.com/y2xfxklu");
        ingredientStorage.saveIngredient(seitan);
        Ingredient tofu = new Ingredient("tofu", "soy sauce,\n apple cider vinegar,\n sesame", "https://tinyurl.com/ydhqxj44", "https://tinyurl.com/y5udk5mp", "mushroom,\n ginger,\n soy sauce", "https://tinyurl.com/y3oxhont", "https://tinyurl.com/yxlh7rd3", "turmeric,\n nutritional yeast,\n paprika", "https://lovingitvegan.com/vegan-tofu-scramble/", "https://lovingitvegan.com/wp-content/uploads/2018/03/Vegan-Tofu-Scramble-17.jpg");
        ingredientStorage.saveIngredient(tofu);
        Ingredient chickpeas = new Ingredient("chickpeas", "lemon,\n tahini,\n garlic", "https://www.gimmesomeoven.com/classic-hummus/", "https://www.gimmesomeoven.com/wp-content/uploads/2016/03/Homemade-Hummus-Recipe.jpg", "cumin,\n coriander, \n red onion", "https://www.food.com/recipe/chickpea-burger-338863", "https://img.sndimg.com/food/image/upload/c_thumb,q_80,w_562,h_316/v1/img/recipes/33/88/63/picFBVsqV.jpg", "dates,\n basil,\n parsley", "https://www.loveandlemons.com/chickpea-salad-recipe/", "https://cdn.loveandlemons.com/wp-content/uploads/2019/08/IMG_20529.jpg");
        ingredientStorage.saveIngredient(chickpeas);
        Ingredient eggplant = new Ingredient("eggplant", "tomatoes,\n mozzarella,\n basil", "https://www.gimmesomeoven.com/baked-eggplant-parmesan-recipe/", "https://www.gimmesomeoven.com/wp-content/uploads/2015/07/Baked-Eggplant-Parmesan-Recipe-1.jpg", "turmeric,\n paprika,\n coriander", "https://www.themediterraneandish.com/braised-eggplant-recipe-greek-style/", "https://www.themediterraneandish.com/wp-content/uploads/2020/03/braised-eggplant-recipe-greek-style-6.jpg", "lemon,\n olive oil,\n tahini", "https://www.themediterraneandish.com/baba-ganoush-recipe/", "https://www.themediterraneandish.com/wp-content/uploads/2015/10/Baba-Ganoush-Recipe-100.jpg");
        ingredientStorage.saveIngredient(eggplant);
        Ingredient mushrooms = new Ingredient("mushrooms", "garam masala,\n fenugreek leaves,\n cashews","https://ministryofcurry.com/mushroom-masala/", "https://ministryofcurry.com/wp-content/uploads/2020/02/mushroom-masala-1-2.jpg", "thyme,\n sherry,\n shallot", "https://afoodcentriclife.com/mushrooms-duxelles/", "https://afoodcentriclife.com/wp-content/uploads/2015/02/Mushroom-Duxelles-201-Edit.jpg", "basil,\n parsley,\n garlic", "https://www.tasteofhome.com/recipes/best-ever-stuffed-mushrooms/", "https://www.tasteofhome.com/wp-content/uploads/2018/01/exps179920_SD153208D08_20_4b-1-696x696.jpg");
        ingredientStorage.saveIngredient(mushrooms);
        Ingredient lentils = new Ingredient("lentils", "ginger,\n garam masala,\n cayenne", "https://www.allrecipes.com/recipe/12960/moroccan-lentil-soup/", "https://i.pinimg.com/originals/70/63/d2/7063d2962ac7b3b0ae994405eb051e9f.jpg", "coconut milk,\n ginger,\n coriander", "https://www.theendlessmeal.com/creamy-coconut-lentil-curry/", "https://www.theendlessmeal.com/wp-content/uploads/2016/07/Creamy-Coconut-Lentil-Curry-680-2.jpg", "tomato,\n turmeric,\n ginger", "https://www.epicurious.com/recipes/food/views/red-lentil-dal-101019", "https://assets.epicurious.com/photos/57c5aaf0d8f441e50948d295/master/pass/red-lentil-dal.jpg");
        ingredientStorage.saveIngredient(lentils);
        Ingredient mountainDew = new Ingredient("mountain dew", "hot Cheetos,\n mozzarella,\n olive oil", "https://www.insider.com/cookbook-review-mountain-dew-grilled-cheese-cupcakes-cocktails-2020", "https://i.insider.com/5fbbdb0732f2170011f70a03?width=700&format=jpeg&auto=webp", "lime,\n tequila,\n Midori", "https://copykat.com/copycat-red-lobster-dew-garita/", "https://copykat.com/wp-content/uploads/2020/11/Red-Lobster-Dew-Garita-Pin1.jpg", "cream cheese,\n vanilla,\n lemon", "https://www.tastemade.com/videos/mountain-dew-cheesecake", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzqkdSzLLxa9gL_51zGwWH13ufBmKEK-o0Og&usqp=CAU");
        ingredientStorage.saveIngredient(mountainDew);




        Pairing boldLemon = new Pairing("lemon", Pairing.DietaryFilter.SOUR ,1,  chicken, salmon, shrimp, eggplant, chickpeas);
        pairingStorage.savePairing(boldLemon);
        Pairing normalLemon = new Pairing( "lemon" , Pairing.DietaryFilter.SOUR ,2, steak, pasta);
        pairingStorage.savePairing(normalLemon);
        Pairing italicLemon = new Pairing("lemon",Pairing.DietaryFilter.SOUR ,3, pork, lamb, seitan, tofu, mountainDew);
        pairingStorage.savePairing(italicLemon);


        Pairing boldTeriyakiSauce = new Pairing( "teriyaki sauce", Pairing.DietaryFilter.SALTY ,1, salmon, steak, chicken, seitan,tofu, pork);
        pairingStorage.savePairing(boldTeriyakiSauce);
        Pairing italicTeriyakiSauce = new Pairing("teriyaki sauce", Pairing.DietaryFilter.SALTY,3, eggs, lamb);
        pairingStorage.savePairing(italicTeriyakiSauce);

        Pairing capsGarlic = new Pairing("GARLIC", Pairing.DietaryFilter.SWEET,1, chicken, steak, shrimp, pasta, lamb, tofu, chickpeas);
        pairingStorage.savePairing(capsGarlic);
        Pairing italicGarlic = new Pairing( "garlic", Pairing.DietaryFilter.SWEET,3, pork, seitan);
        pairingStorage.savePairing(italicGarlic);

        Pairing capsOnions = new Pairing("ONIONS", Pairing.DietaryFilter.SWEET,1, chicken, steak, shrimp, pasta, eggs, lamb, seitan, pork, tofu, chickpeas, mushrooms);
        pairingStorage.savePairing(capsOnions);

        Pairing normalCumin = new Pairing("cumin", Pairing.DietaryFilter.SMOKY,2,chicken, steak, pork, lamb, tofu, seitan);
        pairingStorage.savePairing(normalCumin);

        Pairing boldPotatoes = new Pairing("potatoes", Pairing.DietaryFilter.SWEET ,1, chicken, steak, pork, lamb);
        pairingStorage.savePairing(boldPotatoes);
        Pairing capsPotatoes = new Pairing("POTATOES", Pairing.DietaryFilter.SWEET,1, eggs, salmon);
        pairingStorage.savePairing(capsPotatoes);

        Pairing capsRosemary = new Pairing("ROSEMARY", Pairing.DietaryFilter.SWEET,1, chicken, steak, pork, lamb );
        pairingStorage.savePairing(capsRosemary);
        Pairing normalRosemary = new Pairing("rosemary", Pairing.DietaryFilter.SWEET,2, pasta, tofu);
        pairingStorage.savePairing(normalRosemary);

        Pairing capsButter = new Pairing("BUTTER", Pairing.DietaryFilter.UMAMI,1, salmon, chicken, steak, pork, lamb);
        pairingStorage.savePairing(capsButter);
        Pairing boldButter = new Pairing("butter", Pairing.DietaryFilter.UMAMI,1, shrimp, eggs, pasta);
        pairingStorage.savePairing(boldButter);

        Pairing capsTomatoes = new Pairing("TOMATOES", Pairing.DietaryFilter.SWEET,1, chicken, shrimp, pasta, seitan);
        pairingStorage.savePairing(capsTomatoes);
        Pairing normalTomatoes = new Pairing("tomatoes", Pairing.DietaryFilter.SWEET,2, eggs);
        pairingStorage.savePairing(normalTomatoes);

        Pairing boldTomatoes = new Pairing("tomatoes", Pairing.DietaryFilter.SWEET,1, pork, lamb);
        pairingStorage.savePairing(boldTomatoes);

        Pairing capsBasil = new Pairing("BASIL", Pairing.DietaryFilter.SWEET,1, chicken, pasta, tofu);
        pairingStorage.savePairing(capsBasil);
        Pairing italicsBasil = new Pairing("basil", Pairing.DietaryFilter.SWEET,3, eggs, seitan, lamb, chickpeas);
        pairingStorage.savePairing(italicsBasil);

        Pairing capsGinger = new Pairing("GINGER", Pairing.DietaryFilter.SOUR,1, chicken, salmon, pork, tofu);
        pairingStorage.savePairing(capsGinger);
        Pairing boldGinger = new Pairing("ginger", Pairing.DietaryFilter.SOUR,1, lamb, lentils);
        pairingStorage.savePairing(boldGinger);
        Pairing normalGinger = new Pairing("ginger", Pairing.DietaryFilter.SOUR,2, seitan);
        pairingStorage.savePairing(normalGinger);

        Pairing boldBacon = new Pairing("bacon", Pairing.DietaryFilter.SALTY,1, chicken, shrimp, eggs, pasta);
        pairingStorage.savePairing(boldBacon);
        Pairing normalBacon = new Pairing("bacon", Pairing.DietaryFilter.SALTY,2, lamb);
        pairingStorage.savePairing(normalBacon);

        Pairing capsMushroom = new Pairing("MUSHROOMS", Pairing.DietaryFilter.UMAMI,1, chicken, eggs, pasta, seitan, tofu);
        pairingStorage.savePairing(capsMushroom);
        Pairing boldMushroom = new Pairing("mushrooms",Pairing.DietaryFilter.UMAMI,1, steak, shrimp);
        pairingStorage.savePairing(boldMushroom);
        Pairing normalMushroom = new Pairing("mushroom", Pairing.DietaryFilter.UMAMI,2, lamb, pork);
        pairingStorage.savePairing(normalMushroom);

        Pairing normalRice = new Pairing("rice", Pairing.DietaryFilter.SWEET,2, steak, shrimp, eggs, pork);
        pairingStorage.savePairing(normalRice);
        Pairing boldRice = new Pairing("rice", Pairing.DietaryFilter.SWEET,1, chicken, salmon, lamb, seitan, tofu);
        pairingStorage.savePairing(boldRice);

        Pairing boldPasta = new Pairing("pasta", Pairing.DietaryFilter.SWEET, 1, chicken, steak, shrimp);
        pairingStorage.savePairing(boldPasta);

        Pairing normalRedBeans = new Pairing("red beans", Pairing.DietaryFilter.UMAMI, 2, chicken, pork);
        pairingStorage.savePairing(normalRedBeans);

        Pairing normalAndouilleSausage = new Pairing("andouille sausage", Pairing.DietaryFilter.SMOKY, 2, chicken, pork, shrimp, eggs, mushrooms, lentils);
        pairingStorage.savePairing(normalAndouilleSausage);

        Pairing boldApple = new Pairing("apple: fresh, juice", Pairing.DietaryFilter.SWEET, 1, chicken, lamb);
        pairingStorage.savePairing(boldApple);
        Pairing capsApple = new Pairing("APPLE: fresh, juice", Pairing.DietaryFilter.SWEET, 1, pork);
        pairingStorage.savePairing(capsApple);
        Pairing boldAppleCiderVinegar = new Pairing("apple cider vinegar", Pairing.DietaryFilter.SOUR, 1, chicken, tofu, shrimp);
        pairingStorage.savePairing(boldAppleCiderVinegar);
        Pairing capsAppleCiderVinegar = new Pairing("APPLE CIDER VINEGAR", Pairing.DietaryFilter.SOUR, 1, pork);
        pairingStorage.savePairing(capsAppleCiderVinegar);

        Pairing normalEndive = new Pairing("endive", Pairing.DietaryFilter.BITTER, 2, chicken, shrimp, mushrooms, salmon);
        pairingStorage.savePairing(normalEndive);

        Pairing normalWalnuts = new Pairing("walnuts", Pairing.DietaryFilter.BITTER, 2, chicken, lentils, pasta, chickpeas);
        pairingStorage.savePairing(normalWalnuts);

        Pairing normalNori = new Pairing("nori", Pairing.DietaryFilter.BITTER, 2, salmon, tofu, shrimp);
        pairingStorage.savePairing(normalNori);

        Pairing boldSoySauce = new Pairing("soy sauce", Pairing.DietaryFilter.SALTY, 1, salmon, chicken, steak, shrimp, tofu, seitan, mushrooms, pork);
        pairingStorage.savePairing(boldSoySauce);

        Pairing normalAsparagus = new Pairing("asparagus", Pairing.DietaryFilter.BITTER, 2, salmon, steak, shrimp, pasta, mushrooms);
        pairingStorage.savePairing(normalAsparagus);

        Pairing italicCilantro = new Pairing("cilantro", Pairing.DietaryFilter.SWEET, 3, pork, chicken, salmon, shrimp, lentils, lamb, eggplant);
        pairingStorage.savePairing(italicCilantro);

        Pairing normalScallion = new Pairing("scallion", Pairing.DietaryFilter.UMAMI, 2, pork, salmon, chicken, shrimp, tofu, seitan, chickpeas, eggplant, mushrooms, lentils);
        pairingStorage.savePairing(normalScallion);

        Pairing normalSerrano = new Pairing("serrano peppers", Pairing.DietaryFilter.SMOKY, 2, pork, salmon, chicken, shrimp, tofu, seitan, chickpeas, mushrooms, lentils);
        pairingStorage.savePairing(normalSerrano);

        Pairing normalThyme = new Pairing("thyme", Pairing.DietaryFilter.SWEET, 2, steak, chicken, lamb, shrimp, lentils, mushrooms, pasta, chickpeas, eggplant);
        pairingStorage.savePairing(normalThyme);

        Pairing boldRedWine = new Pairing("red wine", Pairing.DietaryFilter.SWEET, 1, steak, chicken, lamb, pork, mushrooms, pasta, eggplant, lentils);
        pairingStorage.savePairing(boldRedWine);

        Pairing capsOliveOil = new Pairing("OLIVE OIL", Pairing.DietaryFilter.BITTER, 1, chicken, lamb, steak, mushrooms, eggplant, pasta, lentils, tofu, pork, shrimp, mountainDew);
        pairingStorage.savePairing(capsOliveOil);

        Pairing normalOregano = new Pairing("oregano", Pairing.DietaryFilter.SWEET, 2, chicken, lamb, steak, mushrooms, eggplant, pasta, shrimp, pork);
        pairingStorage.savePairing(normalOregano);

        Pairing normalPaprika = new Pairing("paprika", Pairing.DietaryFilter.SMOKY, 2, chicken, lamb, shrimp, pork, pasta, chickpeas, eggplant, mushrooms, tofu);
        pairingStorage.savePairing(normalPaprika);

        Pairing italicChiles = new Pairing("chilies: powder, crushed", Pairing.DietaryFilter.SMOKY, 3, chicken, lamb, shrimp, pork, pasta, chickpeas, eggplant, mushrooms, eggs, lentils);
        pairingStorage.savePairing(italicChiles);

        Pairing normalLime = new Pairing("lime: fresh, juice, zest", Pairing.DietaryFilter.SOUR, 2, mountainDew, shrimp, pork, chicken, salmon);
        pairingStorage.savePairing(normalLime);

        Pairing normalBrownSugar = new Pairing("brown sugar", Pairing.DietaryFilter.SWEET, 2, shrimp, seitan, tofu, pork, eggs);
        pairingStorage.savePairing(normalBrownSugar);

        Pairing italicHorseradish = new Pairing("horseradish", Pairing.DietaryFilter.SOUR, 3, shrimp, pork, steak, lamb);
        pairingStorage.savePairing(italicHorseradish);

        Pairing normalCheddar = new Pairing("cheddar", Pairing.DietaryFilter.UMAMI, 2, chicken, pasta, mushrooms, eggs);
        pairingStorage.savePairing(normalCheddar);
        Pairing normalCreamCheese = new Pairing("cream cheese", Pairing.DietaryFilter.SWEET, 2, mountainDew, eggs, pasta);
        pairingStorage.savePairing(normalCreamCheese);
        Pairing boldMozzarella = new Pairing("mozzarella", Pairing.DietaryFilter.UMAMI, 1, chicken, mushrooms, eggplant, pasta, eggs);
        pairingStorage.savePairing(boldMozzarella);
        Pairing normalGruyere = new Pairing("Gruyere", Pairing.DietaryFilter.UMAMI, 2, pasta, chicken, mushrooms, eggs);
        pairingStorage.savePairing(normalGruyere);

        Pairing normalVanilla = new Pairing("vanilla", Pairing.DietaryFilter.SWEET, 2, eggs, mountainDew);
        pairingStorage.savePairing(normalVanilla);

        Pairing normalPineapple = new Pairing("pineapple", Pairing.DietaryFilter.SWEET, 2, pork, shrimp, chicken, tofu, steak);
        pairingStorage.savePairing(normalPineapple);

        Pairing italicFennel = new Pairing("fennel", Pairing.DietaryFilter.BITTER, 3, pork, chicken, mushrooms, eggplant, salmon);
        pairingStorage.savePairing(italicFennel);

        Pairing normalParsley = new Pairing("parsley", Pairing.DietaryFilter.BITTER, 2, pork, chicken, shrimp, lamb, steak, mushrooms, eggplant, lentils, chickpeas);
        pairingStorage.savePairing(normalParsley);

        Pairing normalMint = new Pairing("mint", Pairing.DietaryFilter.SWEET, 2, eggplant, lentils, chickpeas, chicken);
        pairingStorage.savePairing(normalMint);
        Pairing boldMint = new Pairing("mint", Pairing.DietaryFilter.SWEET, 1, lamb);
        pairingStorage.savePairing(boldMint);

        Pairing normalPeas = new Pairing("peas", Pairing.DietaryFilter.SWEET, 2, lamb, chicken, lentils, mushrooms);
        pairingStorage.savePairing(normalPeas);

        Pairing normalCoriander = new Pairing("coriander", Pairing.DietaryFilter.SWEET, 2, seitan, chickpeas, eggplant, lentils, mushrooms);
        pairingStorage.savePairing(normalCoriander);

        Pairing normalCurryPowder = new Pairing("curry powder", Pairing.DietaryFilter.SMOKY, 2, seitan, tofu, chicken, eggplant, mushrooms, pork, shrimp);
        pairingStorage.savePairing(normalCurryPowder);

        Pairing normalSesame = new Pairing("sesame: seeds, oil", Pairing.DietaryFilter.UMAMI, 2, seitan, tofu, chicken, mushrooms, pork, shrimp, salmon);
        pairingStorage.savePairing(normalSesame);

        Pairing normalTurmeric = new Pairing("turmeric", Pairing.DietaryFilter.BITTER, 2, seitan, tofu, chicken, shrimp, eggplant, lamb, mushrooms);
        pairingStorage.savePairing(normalTurmeric);

        Pairing normalNutritionalYeast = new Pairing("nutritional yeast", Pairing.DietaryFilter.UMAMI, 2, seitan, tofu, eggplant, eggs, mushrooms);
        pairingStorage.savePairing(normalNutritionalYeast);

        Pairing normalTahini = new Pairing("tahini", Pairing.DietaryFilter.SWEET, 2, chickpeas, eggplant, mushrooms);
        pairingStorage.savePairing(normalTahini);

        Pairing normalDates = new Pairing("dates", Pairing.DietaryFilter.SWEET, 2, chickpeas, chicken, pork, lamb, pasta);
        pairingStorage.savePairing(normalDates);

        Pairing normalGaramMasala = new Pairing("garam masala", Pairing.DietaryFilter.SMOKY, 2, chickpeas, eggplant, chicken, tofu, seitan, mushrooms, lamb, lentils);
        pairingStorage.savePairing(normalGaramMasala);

        Pairing normalFenugreekLeaves = new Pairing("fenugreek leaves", Pairing.DietaryFilter.BITTER, 2, mushrooms, chicken, tofu, lentils, pork, eggplant);
        pairingStorage.savePairing(normalFenugreekLeaves);

        Pairing normalCashews = new Pairing("cashews", Pairing.DietaryFilter.SWEET, 2, mushrooms, chicken, tofu, seitan, mountainDew);
        pairingStorage.savePairing(normalCashews);

        Pairing normalSherry = new Pairing("sherry", Pairing.DietaryFilter.SWEET, 2, mushrooms, chicken, steak, pork, pasta);
        pairingStorage.savePairing(normalSherry);

        Pairing boldShallots = new Pairing("shallots", Pairing.DietaryFilter.SWEET, 1, mushrooms, chicken, pork, steak, pasta, tofu, seitan, lentils, eggplant, eggs);
        pairingStorage.savePairing(boldShallots);

        Pairing boldCoconutMilk = new Pairing("coconut milk", Pairing.DietaryFilter.SWEET, 1, lentils, shrimp, chicken, tofu, seitan, mushrooms);
        pairingStorage.savePairing(boldCoconutMilk);

        Pairing capsFlaminHotCheetos = new Pairing("FLAMIN' HOT CHEETOS", Pairing.DietaryFilter.SALTY, 1, mountainDew);
        pairingStorage.savePairing(capsFlaminHotCheetos);

        Pairing capsTequila = new Pairing("TEQUILA", Pairing.DietaryFilter.SWEET, 1, mountainDew);
        pairingStorage.savePairing(capsTequila);

        Pairing normalMidori = new Pairing("Midori", Pairing.DietaryFilter.SWEET, 2, mountainDew);
        pairingStorage.savePairing(normalMidori);





















    }
}
