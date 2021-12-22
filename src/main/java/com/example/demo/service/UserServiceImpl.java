package com.example.demo.service;

import com.example.demo.UserRepository.UserRepository;
import com.example.demo.dto.request.UserPostRequest;
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

    @Override
    public void create(UserPostRequest userPostRequest) {

        User user = new User();
        user.setUsername(userPostRequest.getUsername());
        user.setPassword(userPostRequest.getPassword());
        user.setEmail(userPostRequest.getEmail());
        User savedUser = userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        Optional<User> possibleUser = userRepository.findByUsername(username);
        if (possibleUser.isPresent()) {
            User user = possibleUser.get();
            userRepository.delete(user);
        }
    }



}
