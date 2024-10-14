package com.stranger.strangerService.mapper;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FriendMapper {
    private String username;
    private String fullName;
}
