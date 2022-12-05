package com.example.thisweek7task.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSignIn {
    private String fullName;
    private String email;
    private  String gender;
    private String password;
}
