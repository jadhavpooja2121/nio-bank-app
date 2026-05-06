package com.niobank.controller;

import com.niobank.request.UserRequestDTO;
import com.niobank.response.UserResponse;
import com.niobank.respository.UserRepository;
import com.niobank.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponse responseuser = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(responseuser) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser (@PathVariable(name = "id") Integer userId ){
        UserResponse response = userService.getUser(userId);
        return org.springframework.http.ResponseEntity.ok(response);
    }
}
