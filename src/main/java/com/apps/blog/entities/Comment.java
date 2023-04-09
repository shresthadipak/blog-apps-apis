package com.apps.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.PrivateKey;

@Entity
@Table(name = "comments")
@Setter
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    private User user;

}
