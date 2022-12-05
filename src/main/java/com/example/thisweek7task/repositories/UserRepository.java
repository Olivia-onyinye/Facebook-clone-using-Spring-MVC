package com.example.thisweek7task.repositories;

import com.example.thisweek7task.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   Optional<User>findUserByEmailAndPassword(String email, String password);
}