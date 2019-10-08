package com.rest.webservices.service;

import com.rest.webservices.model.entities.User;

import java.util.List;
import java.util.UUID;


public interface UserService {
    public User getUser(String id);

    public List<User> getAllUsers();

    public UUID addUser(User userDetais);

}
