package com.tastebuds.webapp.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pairing {


    @ManyToOne
    private PairingClass pairingClass;
    private String pairing;
    private int textStyle;
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany
    @JsonIgnore
    private Set<Ingredient> ingredients;

    public Pairing(PairingClass pairingClass, String pairing, int textStyle, Ingredient...ingredients) {
        this.pairingClass = pairingClass;
        this.pairing = pairing;
        this.textStyle = textStyle;
        this.ingredients = Set.of(ingredients);
    }

    protected Pairing(){
    }


    public PairingClass getPairingClass() {
        return pairingClass;
    }

    public String getPairing() {
        return pairing;
    }

    public int getTextStyle() {
        return textStyle;
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
        return textStyle == pairing1.textStyle &&
                Objects.equals(pairingClass, pairing1.pairingClass) &&
                Objects.equals(pairing, pairing1.pairing) &&
                Objects.equals(id, pairing1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairingClass, pairing, textStyle, id);
    }

    @Override
    public String toString() {
        return "Pairing{" +
                "pairingClass=" + pairingClass +
                ", pairing='" + pairing + '\'' +
                ", textStyle=" + textStyle +
                ", id=" + id +
                '}';
    }
}
