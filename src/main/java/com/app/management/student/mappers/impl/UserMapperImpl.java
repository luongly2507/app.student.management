package com.app.management.student.mappers.impl;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.management.student.entities.User;
import com.app.management.student.mappers.UserMapper;
import com.app.management.student.payloads.requests.UserSignUpRequest;
import com.app.management.student.repositories.RoleRepository;

@Component
@Transactional
public class UserMapperImpl implements UserMapper{

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Override
    public User toUser(UserSignUpRequest userSignUpRequest) {
        if (userSignUpRequest == null){
            return null;
        }
        User user = User.builder()
                .email(userSignUpRequest.getEmail())
                .fullName(userSignUpRequest.getFullName())
                .password(passwordEncoder.encode(userSignUpRequest.getPassword()))
                .roles(Arrays.asList(roleRepository.findByName("ROLE_USER").get()))
                .build();
        return user;
    }
    
}
