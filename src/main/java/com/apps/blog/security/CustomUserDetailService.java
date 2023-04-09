package com.apps.blog.security;

import com.apps.blog.entities.User;
import com.apps.blog.exceptions.ResourceNotFoundException;
import com.apps.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Loading username from database
        User user = this.userRepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundException("User", "Email: "+username, 0));
        return user;
    }
}
