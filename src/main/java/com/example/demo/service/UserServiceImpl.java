package com.example.demo.service;

import com.example.demo.dto.request.UserPostRequest;
import com.example.demo.dto.response.UserRateResponse;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
    public String create(UserPostRequest userPostRequest) {
        try {

            String encryptedPassword = passwordEncoder.encode(userPostRequest.getPassword());

            User user = new User();
            user.setUsername(userPostRequest.getUsername());
            user.setPassword(encryptedPassword);
            user.setEmail(userPostRequest.getEmail());
            user.setEnabled(true);
            User savedUser = userRepository.save(user);
            savedUser.addAuthority("ROLE_USER");

            userRepository.save(savedUser);
            return savedUser.getUsername();
        } catch (Exception ex) {
            throw new BadRequestException("Cannot create user.");
        }
    }

    @Override
    public void delete(String username) {
        Optional<User> possibleUser = userRepository.findByUsername(username);
        if (possibleUser.isPresent()) {
            User user = possibleUser.get();
            userRepository.delete(user);
        }
    }

    @Override
    public UserRateResponse getUserById(long user_id) {
        String ratedUserName = null;
        try {
            Optional<User> user = userRepository.findById(user_id);
            if (user.isPresent()) {
                ratedUserName = user.get().username;

            }

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        }
        return new UserRateResponse(ratedUserName);
    }

    @Override
    public void disableUser(long user_id) {
        Optional<User> optionalUser = userRepository.findById(user_id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEnabled(false);
            userRepository.save(user);
        }
        else {
            throw new UserNotFoundException();
        }

    }

}
