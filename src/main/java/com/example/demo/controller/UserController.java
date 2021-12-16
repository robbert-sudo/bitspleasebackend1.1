package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
