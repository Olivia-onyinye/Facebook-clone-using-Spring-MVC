package com.example.thisweek7task.services;

import com.example.thisweek7task.dto.UserDto;
import com.example.thisweek7task.entities.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    User userCreate(UserDto userDto);
    User login(String email, String password);
    List<User>getAllUsers();
    Optional<User> getUserById(Long user_id);
    //UserResponseDto getUserById(Long user_id);
    void userDelete(Long user_id);
    void userUpdate(Long user_id, String fullName, String email);
}
