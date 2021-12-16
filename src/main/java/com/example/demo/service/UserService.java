package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;


public interface UserService {

    public Iterable<User> findAll();

    Optional<User> getUser(String username);
}
