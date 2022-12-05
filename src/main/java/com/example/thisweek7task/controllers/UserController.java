package com.example.thisweek7task.controllers;

import com.example.thisweek7task.dto.UserDto;
import com.example.thisweek7task.entities.User;
import com.example.thisweek7task.models.UserSignIn;
import com.example.thisweek7task.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/facebook")
public class UserController {
    private final UserService userService;

     @GetMapping("/signup")
     public String signupView(Model model){
        model.addAttribute("userSignIn", new UserSignIn());
        return "signup";
}

    @GetMapping("/")
    public String homePage(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("listOfUsers", userList);
        return "home";
    }
//    @GetMapping("/profile/{user_id")
//    public ResponseEntity<UserResponseDto> getUser (@PathVariable Long user_id){
//         UserResponseDto userResponseDto = userService.getUserById(user_id);
//                 return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
//    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute UserSignIn userSignIn, Model model, UserDto userDto){
        userService.userCreate(userDto);
        userService.login(userDto.getEmail(), userDto.getPassword());
        model.addAttribute("userSignIn", userSignIn);
        return "redirect:/facebook/login";
    }

    @PostMapping("/delete/{user_id}")
    public String deleteUser(@PathVariable("user_id") Long user_id){
        userService.userDelete(user_id);
        return "redirect:/facebook/home";
    }


    @PutMapping("/")
    public ResponseEntity<String>updateUser(
            @PathVariable Long user_id,
            @RequestParam (required = false) String fullName,
            @RequestParam(required = false) String email){
        userService.userUpdate(user_id,fullName, email);
        return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
    }
}
