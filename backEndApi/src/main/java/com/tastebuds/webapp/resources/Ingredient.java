package com.tastebuds.webapp.resources;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Ingredient {
    private String ingredient;
    @GeneratedValue
    @Id
    private Long id;
    @ManyToMany(mappedBy = "ingredients")
    @OrderBy("textStyle ASC, name ASC")
    private Set<Pairing> pairings;
    private String affinity1;
    private String affinity1Url;
    private String affinity1Photo;
    private String affinity2;
    private String affinity2Url;
    private String affinity2Photo;
    private String affinity3;
    private String affinity3Url;
    private String affinity3Photo;

    public Ingredient(String ingredient, String affinity1, String affinity1Url, String affinity1Photo, String affinity2, String affinity2Url, String affinity2Photo, String affinity3, String affinity3Url, String affinity3Photo) {
        this.ingredient = ingredient;
        this.affinity1 = affinity1;
        this.affinity1Url = affinity1Url;
        this.affinity1Photo = affinity1Photo;
        this.affinity2 = affinity2;
        this.affinity2Url = affinity2Url;
        this.affinity2Photo = affinity2Photo;
        this.affinity3 = affinity3;
        this.affinity3Url = affinity3Url;
        this.affinity3Photo = affinity3Photo;
    }

    protected Ingredient () {

    }

    public String getIngredient() {
        return ingredient;
    }

    public Long getId() {
        return id;
    }

    public List<Pairing> getPairings() {
        ArrayList<Pairing> sortedPairings = new ArrayList<>(pairings);
        sortedPairings.sort((pairing1, pairing2) -> String.CASE_INSENSITIVE_ORDER.compare(pairing1.getName(), pairing2.getName()) );
        return sortedPairings;
    }

    public String getAffinity1() {
        return affinity1;
    }

    public String getAffinity1Url() {
        return affinity1Url;
    }

    public String getAffinity1Photo() {
        return affinity1Photo;
    }

    public String getAffinity2() {
        return affinity2;
    }

    public String getAffinity2Url() {
        return affinity2Url;
    }

    public String getAffinity2Photo() {
        return affinity2Photo;
    }

    public String getAffinity3() {
        return affinity3;
    }

    public String getAffinity3Url() {
        return affinity3Url;
    }

    public String getAffinity3Photo() {
        return affinity3Photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return ingredient.equals(that.ingredient) &&
                id.equals(that.id) &&
                affinity1.equals(that.affinity1) &&
                affinity1Url.equals(that.affinity1Url) &&
                affinity1Photo.equals(that.affinity1Photo) &&
                affinity2.equals(that.affinity2) &&
                affinity2Url.equals(that.affinity2Url) &&
                affinity2Photo.equals(that.affinity2Photo) &&
                affinity3.equals(that.affinity3) &&
                affinity3Url.equals(that.affinity3Url) &&
                affinity3Photo.equals(that.affinity3Photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, id, affinity1, affinity1Url, affinity1Photo, affinity2, affinity2Url, affinity2Photo, affinity3, affinity3Url, affinity3Photo);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredient='" + ingredient + '\'' +
                ", id=" + id +
                ", affinity1='" + affinity1 + '\'' +
                ", affinity1Url='" + affinity1Url + '\'' +
                ", affinity1Photo='" + affinity1Photo + '\'' +
                ", affinity2='" + affinity2 + '\'' +
                ", affinity2Url='" + affinity2Url + '\'' +
                ", affinity2Photo='" + affinity2Photo + '\'' +
                ", affinity3='" + affinity3 + '\'' +
                ", affinity3Url='" + affinity3Url + '\'' +
                ", affinity3Photo='" + affinity3Photo + '\'' +
                '}';
    }
}



