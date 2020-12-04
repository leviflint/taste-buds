package com.tastebuds.webapp.controllers;

import com.tastebuds.webapp.Storage.PostStorage;
import com.tastebuds.webapp.resources.Post;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private PostStorage postStorage;

    public PostController(PostStorage postStorage) {
        this.postStorage = postStorage;
    }
    @GetMapping("/api/posts")
        public Iterable<Post> retrieveAllBlogPosts(){
        return postStorage.retrieveAllPosts();
    }
    @GetMapping("api/post/{id}")
        public Post retrievePostById(@PathVariable Long id){
        return postStorage.retrieveById(id);
    }
    @PostMapping("api/post")
    public Iterable<Post> addPost(@RequestBody Post postToAdd){
        postStorage.save(postToAdd);
        return postStorage.retrieveAllPosts();
    }
}

