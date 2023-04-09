package com.apps.blog.services;

import com.apps.blog.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer postId, Integer userId);
    void deleteComment(Integer commentId);
}
