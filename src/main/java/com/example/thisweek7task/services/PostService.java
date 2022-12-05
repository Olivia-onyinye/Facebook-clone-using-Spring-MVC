package com.example.thisweek7task.services;

import com.example.thisweek7task.dto.PostDto;
import com.example.thisweek7task.dto.PostResponseDto;
import com.example.thisweek7task.entities.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post postCreate(PostDto postDto);
    List<Post> getAllPost();
    Optional<Post> getPostById(Long post_id);
    void postDelete(Long post_id);
    void postUpdate(Long post_id, String text_body);
     void postDeleted(Long user_id);
     List<PostResponseDto> fetchAllUserPost(Long user_id);

//    Post postCreateWithId(PostDto postDto, Long user_id);
}
