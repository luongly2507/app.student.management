package com.app.management.student.mappers;

import com.app.management.student.entities.User;
import com.app.management.student.payloads.requests.UserSignUpRequest;

public interface UserMapper {
    public User toUser(UserSignUpRequest userSignUpRequest);
}
