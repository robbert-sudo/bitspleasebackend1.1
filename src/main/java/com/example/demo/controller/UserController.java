package com.example.demo.controller;

import com.example.demo.dto.request.UserPostRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public ResponseEntity getUsers() {
        Iterable<User> users;
        users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/user/{username}")
    public ResponseEntity getUser(@PathVariable("username") String username) {
        Optional<User> user = userService.getUser(username);
        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/user")
    public ResponseEntity createUser(@RequestBody UserPostRequest userPostRequest) {

        userService.create(userPostRequest);
        return ResponseEntity.ok("User aangemaakt");
    }

    @DeleteMapping(value = "/user/{username}")
    public ResponseEntity deleteUser(@PathVariable("username") String username) {
        userService.delete(username);
        return ResponseEntity.ok("User verwijderd!");
    }
}
