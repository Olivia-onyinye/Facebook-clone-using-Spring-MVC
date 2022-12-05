package com.example.thisweek7task.controllers;


import com.example.thisweek7task.dto.PostDto;
import com.example.thisweek7task.entities.Comment;
import com.example.thisweek7task.entities.Post;
import com.example.thisweek7task.entities.User;
import com.example.thisweek7task.models.CommentForm;
import com.example.thisweek7task.models.PostForm;
import com.example.thisweek7task.services.CommentService;
import com.example.thisweek7task.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/facebook")
public class HomeController {
    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/home")
    public ModelAndView homeView(Model model){
        ModelAndView modelAndView = new ModelAndView("home");
        List<Post> posts = postService.getAllPost();
        if(!posts.isEmpty()) {
            modelAndView.addObject("posts", posts);
        }
        modelAndView.addObject("postForm", new PostForm());
        modelAndView.addObject("commentForm", new CommentForm());
        List<Comment> comments = commentService.getAllComment();
            model.addAttribute("comments", comments);
        return modelAndView;
    }
    @GetMapping("/delete/{post_id}")
    public String deleteView(Model model, @PathVariable Long post_id) {
        List<Post> posts = postService.getAllPost();
        List<Comment> comments = commentService.getAllComment();
        return "redirect:/facebook/home";
    }

    @PostMapping("/home")
    public String makePost(@ModelAttribute PostForm postForm,  Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loggedUser");
        PostDto postDto = PostDto.builder()
                .text_body(postForm.getText_body())
                .user(user)
                .build();
        postService.postCreate(postDto);
        model.addAttribute("postForm", postForm);
        postService.getAllPost();
        return "redirect:/facebook/home";
    }

    @PostMapping("/delete/{post_id}")
    public String deletePost(@PathVariable("post_id") Long post_id){
        postService.postDelete(post_id);
        return "redirect:/facebook/home";
    }

    @PutMapping("/edit/{post_id}")
    public String updateUser(
            @PathVariable Long post_id,
            @RequestParam (required = false) String text_body){
        postService.postUpdate(post_id, text_body);
        return "redirect:/facebook/home";
    }

}
