package com.rest.webservices.controllers;

import com.rest.webservices.exceptions.UserNotFoundException;
import com.rest.webservices.model.entities.User;
import com.rest.webservices.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("users")
public class HelloWorldController {
    @Autowired
    UserService userService;

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> helloWorld(@PathVariable String userId) {
        log.info("Inside getUser by userId");
        User user = userService.getUser(userId);
        if (user == null) {
            throw new UserNotFoundException("User Not Found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> helloWorld() {
        log.info("Inside retrieve all Users");

        return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UUID> addUser(@RequestBody User userDetails) {
        log.info("Inside Add User");

        return new ResponseEntity<UUID>(userService.addUser(userDetails), HttpStatus.CREATED);
    }
}
