package com.tastebuds.webapp.resources;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class PairingClass {

    private String className;
    @ManyToMany
    private Set<Ingredient> classIngredients;
    @OneToMany (mappedBy = "classIngredients")
    private Set<Pairing> pairings;
    @GeneratedValue
    @Id
    private Long id;

    public PairingClass(String className) {
        this.className = className;

    }

    protected PairingClass(){
    }

    public String getClassName() {
        return className;
    }

    public Long getId() {
        return id;
    }

    public Set<Ingredient> getClassIngredients() {
        return classIngredients;
    }

    public Set<Pairing> getPairings() {
        return pairings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairingClass that = (PairingClass) o;
        return Objects.equals(className, that.className) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, id);
    }

    @Override
    public String toString() {
        return "PairingClass{" +
                "className='" + className + '\'' +
                ", id=" + id +
                '}';
    }
}
