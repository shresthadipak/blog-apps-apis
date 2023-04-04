package com.apps.blog.controllers;

import com.apps.blog.entities.Post;
import com.apps.blog.payloads.PostDto;
import com.apps.blog.repositories.PostRepo;
import com.apps.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDto createPostDto = this.postService.createPost(postDto, userId, categoryId);
        return  new ResponseEntity<PostDto>(createPostDto, HttpStatus.CREATED);
    }
}
