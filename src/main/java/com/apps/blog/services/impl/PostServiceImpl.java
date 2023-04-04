package com.apps.blog.services.impl;

import com.apps.blog.entities.Category;
import com.apps.blog.entities.Post;
import com.apps.blog.entities.User;
import com.apps.blog.exceptions.ResourceNotFoundException;
import com.apps.blog.payloads.PostDto;
import com.apps.blog.repositories.CategoryRepo;
import com.apps.blog.repositories.PostRepo;
import com.apps.blog.repositories.UserRepo;
import com.apps.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user_id", userId));
        Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category_id", categoryId));
        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setCreatedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post saveNewPost = this.postRepo.save(post);
        return this.modelMapper.map(saveNewPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "post_id", postId));
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category_id", categoryId));
        List<Post> posts = this.postRepo.findByCategory(cat);
        List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "user_id", userId));
        List<Post> posts = this.postRepo.findByUser(user);
        List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return null;
    }
}