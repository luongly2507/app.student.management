package com.app.studentmanagement.services.impl;

import javax.transaction.Transactional;

import com.app.studentmanagement.entities.User;
import com.app.studentmanagement.mapper.UserMapper;
import com.app.studentmanagement.payload.request.UserSignUpRequest;
import com.app.studentmanagement.repositories.UserRepository;
import com.app.studentmanagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
