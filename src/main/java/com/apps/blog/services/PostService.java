package com.apps.blog.services;

import com.apps.blog.entities.Post;
import com.apps.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    // create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    // update
    Post updatePost(PostDto postDto, Integer postId);

    // delete
    void deletePost(Integer postId);

    // get all posts
    List<Post> getAllPost();

    // get single post
    Post getPostById(Integer postId);

    // get all posts by category
    List<Post> getPostByCategory(Integer categoryId);

    // get all posts by user
    List<Post> getPostByUser(Integer userId);

    // search post
    List<Post> searchPosts(String keyword);
}
