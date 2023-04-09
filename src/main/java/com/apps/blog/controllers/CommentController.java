package com.apps.blog.controllers;

import com.apps.blog.payloads.ApiResponse;
import com.apps.blog.payloads.CommentDto;
import com.apps.blog.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/user/{userId}/comments")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @PathVariable Integer postId,
            @PathVariable Integer userId
    ){
        CommentDto createComment = this.commentService.createComment(commentDto, postId, userId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment is deleted Successfully !!", true, 200), HttpStatus.OK);
    }
}
