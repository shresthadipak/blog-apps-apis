package com.apps.blog.payloads;

import com.apps.blog.entities.Category;
import com.apps.blog.entities.Comment;
import com.apps.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private CategoryDto category;
    private UserDto user;
    private Set<CommentDto> comments = new HashSet<>();

}
