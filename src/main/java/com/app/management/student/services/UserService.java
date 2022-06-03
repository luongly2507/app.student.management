package com.app.management.student.services;

import com.app.management.student.entities.User;
import com.app.management.student.payloads.requests.UserSignUpRequest;

public interface UserService {
    public User registerUser(UserSignUpRequest userSignUp);
}
