package com.apps.blog.payloads;

import com.apps.blog.entities.Category;
import com.apps.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
}
