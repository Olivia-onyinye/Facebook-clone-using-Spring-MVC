package com.example.thisweek7task.dto;

import com.example.thisweek7task.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private String text_body;
    private User user;
}
