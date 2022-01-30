package com.example.demo.service;

import com.example.demo.dto.request.UserPostRequest;
import com.example.demo.model.User;

import java.util.Optional;


public interface UserService {

    public Iterable<User> findAll();

    Optional<User> getUser(String username);

    public String create(UserPostRequest userPostRequest);

    void delete(String username);

    Optional<User> getUserById(long user_id);
}
