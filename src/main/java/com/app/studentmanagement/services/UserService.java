package com.app.studentmanagement.services;

import com.app.studentmanagement.entities.User;
import com.app.studentmanagement.payload.request.UserSignUpRequest;

public interface UserService {
    public User registerUser(UserSignUpRequest userSignUp);
}
