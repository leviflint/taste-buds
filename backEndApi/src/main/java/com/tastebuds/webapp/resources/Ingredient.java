package com.tastebuds.webapp.resources;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Ingredient {
    private String ingredient;
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany(mappedBy = "ingredients")
    private Set<Pairing> pairings;
    private String affinity1;
    private String affinity2;
    private String affinity3;


    public Ingredient(String ingredient, String affinity1, String affinity2, String affinity3) {
        this.ingredient = ingredient;
        this.affinity1 = affinity1;
        this.affinity2 = affinity2;
        this.affinity3 = affinity3;
    }
    protected Ingredient () {

    }

    public String getIngredient() {
        return ingredient;
    }

    public Long getId() {
        return id;
    }

    public Set<Pairing> getPairings() {
        return pairings;
    }

    public String getAffinity1() {
        return affinity1;
    }

    public String getAffinity2() {
        return affinity2;
    }

    public String getAffinity3() {
        return affinity3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(id, that.id) &&
                Objects.equals(affinity1, that.affinity1) &&
                Objects.equals(affinity2, that.affinity2) &&
                Objects.equals(affinity3, that.affinity3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, id, affinity1, affinity2, affinity3);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient='" + ingredient + '\'' +
                ", id=" + id +
                ", pairings=" + pairings +
                ", affinity1='" + affinity1 + '\'' +
                ", affinity2='" + affinity2 + '\'' +
                ", affinity3='" + affinity3 + '\'' +
                '}';
    }
}



