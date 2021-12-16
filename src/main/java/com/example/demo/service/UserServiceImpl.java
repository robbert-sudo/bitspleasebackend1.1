package com.example.demo.service;

import com.example.demo.UserRepository.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Iterable<User> findAll() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public Optional<User> getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }


}
