package com.apps.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto-increment
    private int id;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "username", nullable = false, length = 100)
    private String email;
    private String password;
    private String about;

}
