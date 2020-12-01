package com.tastebuds.webapp;

import com.tastebuds.webapp.resources.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, Long> {
}


