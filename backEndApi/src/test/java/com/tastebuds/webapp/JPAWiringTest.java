package com.tastebuds.webapp;

import com.tastebuds.webapp.resources.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    IngredientRepository ingredientRepo;
    @Autowired
    private TestEntityManager entityManager;

@Test
    public void shouldSaveAndRetrieveIngredientObjects () {
        Ingredient testIngredient = new Ingredient("Lemon");
        ingredientRepo.save(testIngredient);
        flushClear();
        Ingredient retrievedIngredient = ingredientRepo.findById(testIngredient.getId()).get();
        assertThat(retrievedIngredient).isEqualTo(testIngredient);
    }

    private void flushClear() {
        entityManager.flush();
        entityManager.clear();
    }
}
