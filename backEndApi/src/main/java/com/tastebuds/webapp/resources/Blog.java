package com.tastebuds.webapp.resources;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    @GeneratedValue
    private Long id;


    private String hashtag;
    private String recipeName;
    private String recipeLink;
    private String photo;

    public Blog( String hashtag, String recipeName, String recipeLink, String photo) {
        this.hashtag = hashtag;
        this.recipeName = recipeName;
        this.recipeLink = recipeLink;
        this.photo = photo;
    }
    protected Blog(){

    }

    public String getHashtag() {
        return hashtag;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeLink() {
        return recipeLink;
    }

    public String getPhoto() {
        return photo;
    }
}
