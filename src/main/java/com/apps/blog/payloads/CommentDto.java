package com.apps.blog.payloads;

import lombok.Getter;
import lombok.Setter;

import java.io.StringBufferInputStream;

@Getter
@Setter
public class CommentDto {
    private Integer commentId;
    private String content;
    private UserDto user;

}
