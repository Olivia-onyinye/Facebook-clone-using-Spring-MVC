package com.example.thisweek7task.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long user_id;
    private String fullName;
    private String email;
    private String gender;
}
