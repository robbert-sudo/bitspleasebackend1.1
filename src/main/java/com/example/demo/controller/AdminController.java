package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getMessage() {
        return new ResponseEntity<>("SECURED REST endpoint: /admin", HttpStatus.OK);
    }

   @DeleteMapping(value = "delete/{username}")
    public ResponseEntity deleteUser(@PathVariable("username") String username) {
        userService.delete(username);
        return ResponseEntity.ok("User verwijderd!");
   }


}
