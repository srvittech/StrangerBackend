package com.stranger.strangerService.service;

import com.stranger.strangerService.model.User;
import com.stranger.strangerService.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> registerUser(User user){
        return ResponseEntity.ok(userRepository.save(user));
    }
}
