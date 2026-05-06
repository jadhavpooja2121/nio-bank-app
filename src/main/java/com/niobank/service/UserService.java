package com.niobank.service;

import com.niobank.request.UserRequestDTO;
import com.niobank.response.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequestDTO userRequestDTO);
    UserResponse getUser(Integer id);
}
