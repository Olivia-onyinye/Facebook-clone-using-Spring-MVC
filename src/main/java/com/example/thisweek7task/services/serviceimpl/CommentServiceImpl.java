package com.example.thisweek7task.services.serviceimpl;

import com.example.thisweek7task.dto.CommentDto;
import com.example.thisweek7task.dto.CommentResponseDto;
import com.example.thisweek7task.entities.Comment;
import com.example.thisweek7task.entities.Post;
import com.example.thisweek7task.entities.User;
import com.example.thisweek7task.repositories.CommentRepository;
import com.example.thisweek7task.repositories.PostRepository;
import com.example.thisweek7task.repositories.UserRepository;
import com.example.thisweek7task.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public void commentCreate(CommentResponseDto commentResponseDto, Long user_id, Long post_id) {
    User user = userRepository.findById(user_id).get();
    Post post = postRepository.findById(post_id).get();

        System.out.println("USER: " + user);
        System.out.println("POST: " + post);

        Comment comment = Comment.builder()
                .text_area(commentResponseDto.getText_area())
                .post(post)
                .user(user)
                .build();

        System.out.println("COMMENT: " + comment);

        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAllComment() {

        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> getCommentById(Long comment_id) {

        return commentRepository.findById(comment_id);
    }

    @Override
    public void commentDelete(Long comment_id) {
        boolean exists = commentRepository.existsById(comment_id);
        if(!exists){
            System.out.println("Comment does not exists");
        }
        commentRepository.deleteById(comment_id);
    }
    @Override
    public void commentUpdate(Long comment_id, String text_area) {
        Comment comment = commentRepository.findById(comment_id).orElse(null);
        if (text_area != null) {
            assert comment != null;
            comment.setText_area(text_area);
        }
    }
}
