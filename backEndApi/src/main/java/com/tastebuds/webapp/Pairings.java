package com.tastebuds.webapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pairings {

    private String pairing;
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany (mappedBy = "pairings")
    private Set<Ingredient> ingredients;

    public Pairings(String pairing, Long id) {
        this.pairing = pairing;
        this.id = id;
    }

    protected Pairings(){
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
        Pairings pairings = (Pairings) o;
        return Objects.equals(pairing, pairings.pairing) &&
                Objects.equals(id, pairings.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairing, id);
    }

    @Override
    public String toString() {
        return "Pairings{" +
                "pairing='" + pairing + '\'' +
                ", id=" + id +
                '}';
    }
}
