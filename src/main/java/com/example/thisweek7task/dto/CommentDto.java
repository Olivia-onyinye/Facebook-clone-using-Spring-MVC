package com.example.thisweek7task.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private String text_area;
    private Long post_id;
    private Long user_id;

}
