package com.parking.parkingapp.controller;

import com.parking.parkingapp.model.User;
import com.parking.parkingapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = service.createUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
}

