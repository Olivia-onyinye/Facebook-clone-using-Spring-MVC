package com.example.thisweek7task.services.serviceimpl;

import com.example.thisweek7task.dto.UserDto;
import com.example.thisweek7task.entities.User;
import com.example.thisweek7task.exceptions.ResourceNotFoundException;
import com.example.thisweek7task.repositories.UserRepository;
import com.example.thisweek7task.services.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User userCreate(UserDto userDto) {
        User user1 = new User();
        BeanUtils.copyProperties(userDto, user1);
        System.out.println(user1);
        return userRepository.save(user1);
    }

    @Override
    public User login(@NonNull String email, @NonNull String password) {
        if(email.isEmpty())
            System.out.println("Details is not correct");
        return userRepository.findUserByEmailAndPassword(email, password)
                .orElseThrow(()-> new ResourceNotFoundException("User not found", "enter a valid credential"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long user_id) {
            return userRepository.findById(user_id);
        }

//    @Override
//    public UserResponseDto getUserById(@NonNull Long user_id) {
//       userRepository.findById(user_id).get();
//        UserResponseDto userResponseDto = new UserResponseDto();
//        BeanUtils.copyProperties(userResponseDto, user);
//        return userResponseDto;
//    }

    @Override
    public void userDelete(Long user_id) {
        boolean exists = userRepository.existsById(user_id);
        if(!exists){
            System.out.println("User does not exists");
        }
        userRepository.deleteById(user_id);
    }

    @Transactional
    public void userUpdate(Long user_id, String fullName, String email) {
        User user = userRepository.findById(user_id).orElse(null);
        if (fullName != null) {
            assert user != null;
            user.setFullName(fullName);
        }
        if(email != null) {
            assert user != null;
            user.setEmail(email);
        }
    }

}
