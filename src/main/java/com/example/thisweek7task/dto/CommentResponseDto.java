package com.example.thisweek7task.dto;

import com.example.thisweek7task.entities.Post;
import com.example.thisweek7task.entities.User;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    private String text_area;
    private Post post;
    private User user;
}
