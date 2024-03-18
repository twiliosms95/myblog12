package com.myblog.myblog12.service;

import com.myblog.myblog12.entity.User;
import com.myblog.myblog12.exception.ResourceNotFoundException;
import com.myblog.myblog12.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User updateUser(User user,String email){
        User existedUser = userRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("User not found with the Email" + email)
        );
        existedUser.setName(user.getName());
        existedUser.setUsername(user.getUsername());
        existedUser.setEmail(user.getEmail());
        existedUser.setPassword(existedUser.getPassword());
        User updatedUSer = userRepository.save(existedUser);
        return updatedUSer;
    }
}
