package com.tastebuds.webapp;

import com.tastebuds.webapp.Storage.IngredientRepository;
import com.tastebuds.webapp.Storage.PairingsRepository;
import com.tastebuds.webapp.resources.Ingredient;
import com.tastebuds.webapp.resources.Pairing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private IngredientRepository ingredientRepo;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PairingsRepository pairingRepo;


    private void flushClear() {
        entityManager.flush();
        entityManager.clear();
    }
    @Test
    public void shouldSaveAndRetrieveIngredientObjects() {
        Ingredient testIngredient = new Ingredient("Lemon", "1", "2", "3");
        ingredientRepo.save(testIngredient);
        flushClear();
        Ingredient retrievedIngredient = ingredientRepo.findById(testIngredient.getId()).get();
        assertThat(retrievedIngredient).isEqualTo(testIngredient);
    }
    @Test
    public void ingredientsHaveManyPairings() {
        Ingredient testIngredient = new Ingredient("chicken","1","2","3");
        ingredientRepo.save(testIngredient);
        Pairing testPairing1 = new Pairing("salt", testIngredient);
        pairingRepo.save(testPairing1);
        Pairing testPairing2 = new Pairing("pepper", testIngredient);
        pairingRepo.save(testPairing2);
        flushClear();
        Ingredient retrieveIngredient = ingredientRepo.findById(testIngredient.getId()).get();

        assertThat(retrieveIngredient.getPairings()).contains(testPairing1, testPairing2);
    }
    @Test
    public void paringsCanHaveManyIngredients(){
        Ingredient testIngredient = new Ingredient("toast","1","2","3");
        ingredientRepo.save(testIngredient);
        Ingredient testIngredient2 = new Ingredient("cinnamon","1","2","3");
        ingredientRepo.save(testIngredient2);
        Pairing testPairing1 = new Pairing("butter", testIngredient, testIngredient2);
        pairingRepo.save(testPairing1);
        flushClear();
        Pairing retrievePairings = pairingRepo.findById(testPairing1.getId()).get();
        assertThat(retrievePairings.getIngredients()).contains(testIngredient, testIngredient2);
    }





}
