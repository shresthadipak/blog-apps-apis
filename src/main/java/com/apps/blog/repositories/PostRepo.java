package com.apps.blog.repositories;

import com.apps.blog.entities.Category;
import com.apps.blog.entities.Post;
import com.apps.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
