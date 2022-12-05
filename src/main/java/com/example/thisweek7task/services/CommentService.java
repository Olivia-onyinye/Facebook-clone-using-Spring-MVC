package com.example.thisweek7task.services;

import com.example.thisweek7task.dto.CommentDto;
import com.example.thisweek7task.dto.CommentResponseDto;
import com.example.thisweek7task.entities.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    void commentCreate(CommentResponseDto commentResponseDto, Long user_id, Long post_id);
    List<Comment> getAllComment();
    Optional<Comment> getCommentById(Long comment_id);
    void commentDelete(Long comment_id);
    void commentUpdate(Long comment_id, String text_area);
}
