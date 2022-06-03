package com.app.management.student.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.management.student.entities.User;
import com.app.management.student.mappers.UserMapper;
import com.app.management.student.payloads.requests.UserSignUpRequest;
import com.app.management.student.repositories.UserRepository;
import com.app.management.student.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public User registerUser(UserSignUpRequest userSignUp) {
        if (userRepository.findByEmail(userSignUp.getEmail()).isPresent()){
            return null;
        }
        return userRepository.save(userMapper.toUser(userSignUp));
    }
    
}
