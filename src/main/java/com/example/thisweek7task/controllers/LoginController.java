package com.example.thisweek7task.controllers;

import com.example.thisweek7task.entities.User;
import com.example.thisweek7task.models.LoginForm;
import com.example.thisweek7task.services.PostService;
import com.example.thisweek7task.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


@Controller
@RequiredArgsConstructor
@RequestMapping("/facebook")
public class LoginController {

    private final UserService userService;
    private final PostService postService;

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }


    @PostMapping("/login")
    public String userLogin(@ModelAttribute LoginForm loginForm, Model model, HttpSession session) {
        User foundUser = userService.login(loginForm.getEmail(), loginForm.getPassword());
        session.setAttribute("loggedUser", foundUser);
        model.addAttribute("loginForm", loginForm);
        return "redirect:/facebook/home";
    }
}
