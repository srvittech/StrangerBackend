package com.stranger.strangerService.model;

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
public class Room {
    @Id
    private String roomId;
    private List<Message> messages;
    private User sender;
    private User receiver;
    private boolean isMsgSeen;

}
