package com.tastebuds.webapp;

import com.tastebuds.webapp.Storage.PostRepository;
import com.tastebuds.webapp.Storage.IngredientRepository;
import com.tastebuds.webapp.Storage.PairingsRepository;
import com.tastebuds.webapp.resources.Post;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private IngredientRepository ingredientRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PairingsRepository pairingRepo;
    @Autowired
    private PostRepository blogRepo;


    private void flushClear() {
        entityManager.flush();
        entityManager.clear();
    }
    @Test
    public void shouldSaveAndRetrieveIngredientObjects() {
        Ingredient testIngredient = new Ingredient("salmon3", "nori,\n rice,\n soy sauce", "https://tinyurl.com/y2wj32vv", "https://tinyurl.com/y4rzgk5u", "asparagus,\n potatoes,\n butter", "https://tinyurl.com/y4qacr9x", "https://tinyurl.com/y6ft6bps", "lettuce,\n tomatoes,\n balsamic vinaigrette", "https://tinyurl.com/y594v45u", "https://tinyurl.com/yyvdl8we");
        ingredientRepo.save(testIngredient);
        flushClear();
        Ingredient retrievedIngredient = ingredientRepo.findById(testIngredient.getId()).get();
        assertThat(retrievedIngredient).isEqualTo(testIngredient);
    }
    @Test
    public void ingredientsHaveManyPairings() {
        Ingredient testIngredient = new Ingredient("salmon", "nori,\n rice,\n soy sauce", "https://tinyurl.com/y2wj32vv", "https://tinyurl.com/y4rzgk5u", "asparagus,\n potatoes,\n butter", "https://tinyurl.com/y4qacr9x", "https://tinyurl.com/y6ft6bps", "lettuce,\n tomatoes,\n balsamic vinaigrette", "https://tinyurl.com/y594v45u", "https://tinyurl.com/yyvdl8we");
        ingredientRepo.save(testIngredient);
        Pairing testPairing1 = new Pairing("salt", Pairing.DietaryFilter.SALTY,2,testIngredient);
        pairingRepo.save(testPairing1);
        Pairing testPairing2 = new Pairing( "pepper", Pairing.DietaryFilter.SMOKY,2, testIngredient);
        pairingRepo.save(testPairing2);
        flushClear();
        Ingredient retrieveIngredient = ingredientRepo.findById(testIngredient.getId()).get();
        assertThat(retrieveIngredient.getPairings()).contains(testPairing1, testPairing2);
    }
    @Test
    public void paringsCanHaveManyIngredients(){
        Ingredient testIngredient = new Ingredient("salmon2", "nori,\n rice,\n soy sauce", "https://tinyurl.com/y2wj32vv", "https://tinyurl.com/y4rzgk5u", "asparagus,\n potatoes,\n butter", "https://tinyurl.com/y4qacr9x", "https://tinyurl.com/y6ft6bps", "lettuce,\n tomatoes,\n balsamic vinaigrette", "https://tinyurl.com/y594v45u", "https://tinyurl.com/yyvdl8we");
        ingredientRepo.save(testIngredient);
        Ingredient testIngredient2 = new Ingredient("salmon", "nori,\n rice,\n soy sauce", "https://tinyurl.com/y2wj32vv", "https://tinyurl.com/y4rzgk5u", "asparagus,\n potatoes,\n butter", "https://tinyurl.com/y4qacr9x", "https://tinyurl.com/y6ft6bps", "lettuce,\n tomatoes,\n balsamic vinaigrette", "https://tinyurl.com/y594v45u", "https://tinyurl.com/yyvdl8we");
        ingredientRepo.save(testIngredient2);
        Pairing testPairing1 = new Pairing( "butter", Pairing.DietaryFilter.BITTER,3, testIngredient, testIngredient2);
        pairingRepo.save(testPairing1);
        flushClear();
        Pairing retrievePairings = pairingRepo.findById(testPairing1.getId()).get();
        assertThat(retrievePairings.getIngredients()).contains(testIngredient, testIngredient2);
    }
    @Test
    public void saveBlogPost() {
        Post testBlog = new Post("shrimp","Cajun Shrimp", "google.com", "#Creamy","img/Cajun Pasta.jpg", "");
        blogRepo.save(testBlog);
        Post retrieveBlog = blogRepo.findById(testBlog.getId()).get();
        assertThat(retrieveBlog).isEqualTo(testBlog);
    }
    @Test
    public void findByNameIgnoringCase(){
        Ingredient testIngredient = new Ingredient("toast","1","2","3","","","","","","");
        ingredientRepo.save(testIngredient);
        Ingredient testIngredient2 = new Ingredient("cinnamon","1","2","3","","","","","","");
        ingredientRepo.save(testIngredient2);
        Pairing testPairing1 = new Pairing( "butter", Pairing.DietaryFilter.BITTER,3, testIngredient);
        pairingRepo.save(testPairing1);
        Pairing testPairing2 = new Pairing( "BUTTER", Pairing.DietaryFilter.BITTER,3, testIngredient2);
        pairingRepo.save(testPairing2);
        flushClear();
        List <Pairing> retrieveList = pairingRepo.findByNameIgnoringCase("butter");
        assertThat(retrieveList).contains(testPairing1, testPairing2);

    }






}
