package com.rest.webservices.service;

import com.rest.webservices.model.entities.User;
import com.rest.webservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String id) {
        return userRepository.findById(UUID.fromString(id)).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UUID addUser(User userDetais) {
        userRepository.save(userDetais);
        return userDetais.getId();
    }
}
