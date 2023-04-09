package com.apps.blog.services.impl;

import com.apps.blog.entities.Comment;
import com.apps.blog.entities.Post;
import com.apps.blog.entities.User;
import com.apps.blog.exceptions.ResourceNotFoundException;
import com.apps.blog.payloads.CommentDto;
import com.apps.blog.repositories.CommentRepo;
import com.apps.blog.repositories.PostRepo;
import com.apps.blog.repositories.UserRepo;
import com.apps.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "userId", userId));
        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        comment.setUser(user);
        Comment saveComment = this.commentRepo.save(comment);
        return this.modelMapper.map(saveComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment", "commentId", commentId));
        this.commentRepo.delete(comment);
    }
}
