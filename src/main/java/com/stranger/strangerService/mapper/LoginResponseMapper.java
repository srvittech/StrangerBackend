package com.stranger.strangerService.mapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseMapper {
    private String message;
    private String token;
    private String email;
    private String name;
}
