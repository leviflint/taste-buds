package com.tastebuds.webapp.resources;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Pairing {


    private DietaryFilter dietaryFilter;
    private String name;
    private int textStyle;
    public enum DietaryFilter {
        SWEET, SOUR , SALTY, BLAND, UMAMI, SMOKY
    }
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany
    @JsonIgnore
    private Set<Ingredient> ingredients;

    public Pairing(String name, DietaryFilter dietaryFilter, int textStyle, Ingredient... ingredients) {
        this.name = name;
        this.textStyle = textStyle;
        this.ingredients = Set.of(ingredients);
        this.dietaryFilter = dietaryFilter;

    }

    protected Pairing(){
    }

    public DietaryFilter getDietaryFilter() {
        return dietaryFilter;
    }

    public String getName() {
        return name;
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
                Objects.equals(name, pairing1.name) &&
                Objects.equals(id, pairing1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, textStyle, id);
    }

    @Override
    public String toString() {
        return "Pairing{" +
                ", name='" + name + '\'' +
                ", textStyle=" + textStyle +
                ", id=" + id +
                '}';
    }
}
