package com.stranger.strangerService.controller;

import com.stranger.strangerService.mapper.LoginMapperRequest;
import com.stranger.strangerService.mapper.LoginResponseMapper;
import com.stranger.strangerService.model.User;
import com.stranger.strangerService.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseMapper> login(@RequestBody LoginMapperRequest userCredentials){
        return userService.loginWith(userCredentials);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }
}
