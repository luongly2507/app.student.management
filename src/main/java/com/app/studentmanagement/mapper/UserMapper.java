package com.app.studentmanagement.mapper;

import com.app.studentmanagement.entities.User;
import com.app.studentmanagement.payload.request.UserSignUpRequest;

public interface UserMapper {
    public User toUser(UserSignUpRequest userSignUpRequest);
}
