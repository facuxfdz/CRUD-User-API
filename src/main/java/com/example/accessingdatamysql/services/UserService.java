package com.example.accessingdatamysql.services;

import java.util.ArrayList;

import com.example.accessingdatamysql.models.User;
import com.example.accessingdatamysql.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll();
    }

}
