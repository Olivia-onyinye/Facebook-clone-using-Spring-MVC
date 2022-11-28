package com.example.thisweek7task.controllers;

import com.example.thisweek7task.dto.CommentResponseDto;
import com.example.thisweek7task.models.CommentForm;
import com.example.thisweek7task.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/facebook/")
public class CommentController {
    private final CommentService commentService;

    @RequestMapping("/comment/{post_id}/{user_id}")
    public String makeComment(@ModelAttribute CommentForm commentForm, Model model, HttpServletRequest request,
                              @PathVariable("post_id") Long post_id,
                              @PathVariable Long user_id) {
        System.out.println("COMMENT FORM"+commentForm);
        CommentResponseDto commentResponseDto = CommentResponseDto.builder()
                .text_area(commentForm.getText_area())
                .build();
        commentService.commentCreate(commentResponseDto, user_id, post_id);
        model.addAttribute("commentForm", commentForm);

        return "redirect:/facebook/home";
    }
}

