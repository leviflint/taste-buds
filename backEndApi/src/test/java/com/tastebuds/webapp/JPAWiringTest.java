package com.tastebuds.webapp;

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
        Ingredient testIngredient = new Ingredient("Lemon");
        ingredientRepo.save(testIngredient);
        flushClear();
        Ingredient retrievedIngredient = ingredientRepo.findById(testIngredient.getId()).get();
        assertThat(retrievedIngredient).isEqualTo(testIngredient);


    }
    @Test
    public void ingredientsHaveManyPairings() {
        Ingredient testIngredient = new Ingredient("chicken");
        ingredientRepo.save(testIngredient);
        Pairing testPairing1 = new Pairing("salt");
        pairingRepo.save(testPairing1);
        Pairing testPairing2 = new Pairing("pepper");
        pairingRepo.save(testPairing2);
        flushClear();
        Ingredient retrieveIngredient = ingredientRepo.findById(testIngredient.getId()).get();
        assertThat(retrieveIngredient.getPairings()).contains(testPairing1, testPairing2);


    }





}
