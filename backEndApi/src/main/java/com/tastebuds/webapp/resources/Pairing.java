package com.tastebuds.webapp.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pairing {

    private String pairing;
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany
    @JsonIgnore
    private Set<Ingredient> ingredients;

    public Pairing(String pairing, Ingredient...ingredients) {
        this.pairing = pairing;
        this.ingredients = Set.of(ingredients);
    }

    protected Pairing(){
    }

    public String getPairing() {
        return pairing;
    }

    public Long getId() {
        return id;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pairing pairing1 = (Pairing) o;
        return Objects.equals(pairing, pairing1.pairing) &&
                Objects.equals(id, pairing1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairing, id);
    }

    @Override
    public String toString() {
        return "Pairing{" +
                "pairing='" + pairing + '\'' +
                ", id=" + id +
                ", ingredients=" + ingredients +
                '}';
    }
}
