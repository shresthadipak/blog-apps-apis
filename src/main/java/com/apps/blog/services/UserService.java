package com.apps.blog.services;

import com.apps.blog.payloads.UserDto;
import com.apps.blog.payloads.UserResponse;

import java.util.List;

public interface UserService {

    UserDto registerNewUser(UserDto user);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    UserResponse getAllUsers(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    void deleteUser(Integer userId);

}
