package com.stranger.strangerService.model;

import com.stranger.strangerService.mapper.FriendMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String username;
    private String fullName;
    private String email;
    private String password;
    private List<FriendMapper> friends;
    private Status status;
}
