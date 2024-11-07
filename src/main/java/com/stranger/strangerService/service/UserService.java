package com.stranger.strangerService.service;

import com.stranger.strangerService.exceptions.DuplicateResourceException;
import com.stranger.strangerService.exceptions.ResourceNotFoundException;
import com.stranger.strangerService.exceptions.UnauthorizedException;
import com.stranger.strangerService.mapper.LoginMapperRequest;
import com.stranger.strangerService.mapper.LoginResponseMapper;
import com.stranger.strangerService.model.User;
import com.stranger.strangerService.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> registerUser(User user) {
        // Check if user with the same email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new DuplicateResourceException("A user with this email already exists.");
        }

        // Save user and return the response
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    public ResponseEntity<LoginResponseMapper> loginWith(LoginMapperRequest userCredentials) {
        User foundUser = userRepository.findByEmail(userCredentials.getEmail());

        if (foundUser == null) {
            throw new ResourceNotFoundException("User not found");
        }

        if (!userCredentials.getPassword().equals(foundUser.getPassword())) {
            throw new UnauthorizedException("Invalid credentials");
        }
        LoginResponseMapper response =  LoginResponseMapper.builder().email(foundUser.getEmail()).name(foundUser.getName()
        ).message("Login successful").token(null).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
