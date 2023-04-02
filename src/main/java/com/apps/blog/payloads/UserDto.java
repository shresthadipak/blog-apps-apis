package com.apps.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotBlank
    @Size(min = 4, message = "Username must be minimum of 4 characters!!")
    private String name;
    @Email(message = "Email address should be in formatted way!!")
    private String email;
    @NotBlank
    @Size(min=6, max=15, message = "Password must be minimum of 6 characters and maximum of 15 characters!!")
    private String password;
    @NotBlank
    private String about;
}
