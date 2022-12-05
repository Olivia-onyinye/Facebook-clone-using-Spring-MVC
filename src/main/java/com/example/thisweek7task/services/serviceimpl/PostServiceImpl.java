package com.example.thisweek7task.services.serviceimpl;

import com.example.thisweek7task.dto.PostDto;
import com.example.thisweek7task.dto.PostResponseDto;
import com.example.thisweek7task.entities.Post;
import com.example.thisweek7task.entities.User;
import com.example.thisweek7task.exceptions.ResourceNotFoundException;
import com.example.thisweek7task.repositories.PostRepository;
import com.example.thisweek7task.repositories.UserRepository;
import com.example.thisweek7task.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public Post postCreate(PostDto postDto) {
        User user = userRepository.findById(postDto.getUser().getUser_id()).get();
        Post post = Post.builder()
                .text_body(postDto.getText_body())
                .fullName(postDto.getUser().getFullName())
                .user(user)
                .build();
        System.out.println(post);
        return postRepository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long post_id) {

        return postRepository.findById(post_id);
    }

    @Override
    public void postDelete(Long post_id) {
        Post post = postRepository.findById(post_id).orElseThrow(()-> new ResourceNotFoundException("Post not found"));
         postRepository.delete(post);
    }

    @Override
    public void postUpdate(Long post_id, String text_body) {
        Post post = postRepository.findById(post_id).orElse(null);
        if (text_body != null) {
            assert post != null;
            post.setText_body(text_body);
        }
    }

    @Override
    public void postDeleted(Long user_id) {
        userRepository.findById(user_id).get();
    }

    @Override
    public List<PostResponseDto> fetchAllUserPost(Long user_id) {
        List<Post> posts = postRepository.findPostsMadeByUser(user_id);
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        posts.forEach(post -> {
            PostResponseDto postResponseDto = new PostResponseDto();
            postResponseDto.setPost_id(post.getPost_id());
            postResponseDto.setText_body(post.getText_body());
        });
        return postResponseDtoList;
    }

//    @Override
//    public Post postCreateWithId(PostDto postDto, Long user_id) {
//        User user =  userRepository.findById(user_id).get();
//        Post post = Post.builder()
//                .text_body(postDto.getText_body())
//                .fullName(postDto.getUser().getFullName())
//                .user(user)
//                .build();
//        System.out.println(post);
//        return postRepository.save(post);
//    }
}

