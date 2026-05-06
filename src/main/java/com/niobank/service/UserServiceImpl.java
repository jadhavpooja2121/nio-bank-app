package com.niobank.service;

import com.niobank.request.UserRequestDTO;
import com.niobank.response.UserResponse;
import com.niobank.respository.UserRepository;
import com.niobank.users.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequestDTO userRequestDTO) {
        User user = User.builder().name(userRequestDTO.getName()).build();
        User saved = userRepository.save(user);
        UserResponse userResponse = UserResponse.builder().id(saved.getId()).username(saved.getName()).build();
        return userResponse;
    }

    @Override
    public UserResponse getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        UserResponse searchedUser = UserResponse.builder().id(user.get().getId()).username(user.get().getName()).build();
        return searchedUser;
    }
}
