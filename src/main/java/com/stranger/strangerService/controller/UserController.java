package com.stranger.strangerService.controller;

import com.stranger.strangerService.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/registerUser")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
