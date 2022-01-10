package com.example.accessingdatamysql.services;

import java.util.ArrayList;
import java.util.Optional;

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

    public Optional<User> getById(Integer id){
        return userRepository.findById(id);
    }

    public boolean deleteUser(Integer id){        
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
