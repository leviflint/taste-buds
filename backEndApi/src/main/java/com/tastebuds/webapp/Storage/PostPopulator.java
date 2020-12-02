package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class PostPopulator implements CommandLineRunner {
  private PostStorage postStorage;
  private PostRepository postRepo;

    public PostPopulator(PostStorage postStorage, PostRepository postRepo) {
        this.postStorage = postStorage;
        this.postRepo = postRepo;
    }


    @Override
    public void run(String...args)throws Exception{
        Post cajunShrimp = new Post("shrimp","Cajun Shrimp", "google.com", "#Creamy","img/cajun-pasta.jpg");
        postStorage.save(cajunShrimp);
        Post chili = new Post("steak","Chili", "chili.com","#Spicy","img/chili.jpg");
        postStorage.save(chili);
    }
}

