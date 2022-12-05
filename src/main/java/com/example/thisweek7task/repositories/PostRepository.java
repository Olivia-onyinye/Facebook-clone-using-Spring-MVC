package com.example.thisweek7task.repositories;

import com.example.thisweek7task.entities.Comment;
import com.example.thisweek7task.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value= "SELECT * FROM posts WHERE user_user_id=?", nativeQuery = true)
    List<Post> findPostsMadeByUser(Long user_id);


}
