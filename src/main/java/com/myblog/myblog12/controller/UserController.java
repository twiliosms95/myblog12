package com.myblog.myblog12.controller;

import com.myblog.myblog12.entity.User;
import com.myblog.myblog12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
//http://localhost:8080/api/user
    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user, @RequestParam String email){
        userService.updateUser(user,email);
        return new ResponseEntity<>("User is Updated", HttpStatus.OK);

    }
}
