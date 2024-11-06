package com.stranger.strangerService.controller;

import com.stranger.strangerService.model.User;
import com.stranger.strangerService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
