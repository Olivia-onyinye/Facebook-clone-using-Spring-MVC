package com.example.thisweek7task.models;


import com.example.thisweek7task.entities.Post;
import com.example.thisweek7task.entities.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
public class CommentForm {
    private String text_area;
    private Post post;
//    private User user;

}
