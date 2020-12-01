package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.PostStorage;
import com.tastebuds.webapp.resources.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private PostStorage postStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }
    @GetMapping("/api/post")
        public Iterable<Post> retrieveAllBlogPost(){
        return postStorage.retrieveAllPosts();
    }
}

