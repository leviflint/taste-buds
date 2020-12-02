package com.tastebuds.webapp.Storage;

import com.tastebuds.webapp.resources.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}


