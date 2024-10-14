package com.stranger.strangerService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.security.Timestamp;
import java.time.DateTimeException;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Message {
    @Id
    private String messageId;
    private User sendBy;
    private User sendTo;
    private Date messageSentTime;


}
