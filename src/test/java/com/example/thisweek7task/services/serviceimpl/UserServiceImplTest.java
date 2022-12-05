package com.example.thisweek7task.services.serviceimpl;

import com.example.thisweek7task.dto.UserDto;
import com.example.thisweek7task.entities.User;
import com.example.thisweek7task.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
   private UserServiceImpl userService;
 private UserDto userDto;

 @BeforeEach
    void setup() {

    }

    @Test
    void userCreateShouldReturnNewUser() {
     userDto = new UserDto("Micheal Okpara", "micheal@gmail.com", "Male", "Micheal12");
     User user = new User();
     BeanUtils.copyProperties(userDto, user);
        User savedUser = userRepository.save(user);
         User user1 = userService.userCreate(userDto);
        given(userRepository.save(user)).willReturn(user);
     lenient().when(userRepository.save(user)).then(invocation -> invocation.getArgument(0));
//     User savedUser = userService.userCreate(userDto);
     lenient().when(userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword())).thenReturn(null);
     assertEquals(savedUser.getFullName(), user1.getFullName());
     assertEquals(savedUser.getEmail(), user1.getEmail());
     verify(userRepository).save(any(User.class));
    }

    @Test
    void login() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void userDelete() {
    }

    @Test
    void userUpdate() {
    }
}