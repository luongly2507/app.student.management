package com.app.studentmanagement.mapper.impl;

import java.util.Arrays;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.User;
import com.app.studentmanagement.mapper.UserMapper;
import com.app.studentmanagement.payload.request.UserSignUpRequest;
import com.app.studentmanagement.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserMapperImpl implements UserMapper{

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    public User toUser(UserSignUpRequest userSignUpRequest) {
        User user = User.builder()
                .email(userSignUpRequest.getEmail())
                .fullName(userSignUpRequest.getFullName())
                .password(passwordEncoder.encode(userSignUpRequest.getPassword()))
                .roles(Arrays.asList(roleRepository.findByName("ROLE_USER").get()))
                .build();
        return user;
    }
    
}
