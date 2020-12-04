package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Post;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class PostStorage {


    private PostRepository postRepo;

    public PostStorage(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    public Iterable<Post> retrieveAllPosts() {
        return postRepo.findAll();
    }

    public void save(Post post) {
        postRepo.save(post);
    }

    public Post retrieveById(Long id) {
        return postRepo.findById(id).get();
    }

}
