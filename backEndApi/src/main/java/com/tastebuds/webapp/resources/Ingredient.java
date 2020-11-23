package com.tastebuds.webapp.resources;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
        this.id = id;
    }

    protected Ingredient() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, id);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient='" + ingredient + '\'' +
                ", id=" + id +
                '}';
    }
}



