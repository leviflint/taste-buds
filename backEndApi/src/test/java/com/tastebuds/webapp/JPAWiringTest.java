package com.tastebuds.webapp;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class JPAWiringTest {


    public void shouldSaveAndRetrieveIngredientObjects () {
        Ingredient testIngredient = new Ingredient();
    }
}
