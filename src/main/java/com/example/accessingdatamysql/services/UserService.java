package com.example.accessingdatamysql.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.accessingdatamysql.models.User;
import com.example.accessingdatamysql.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // This class will be a service. It means a class with all business logic separated from @RestController class file
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User newUser) {
        return userRepository.save(newUser); // Save method update the DB if primary key is provided. That's why its name is save() and not create()
    }

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userRepository.findAll(); // It returns a Iterable<User> so we cast it to ArrayList<User>
    }

    public Optional<User> getById(Integer id){ // It could not find anything so the return type should be Optional<User>
        return userRepository.findById(id);
    }

    public boolean deleteUser(Integer id){ // This is a design decision. DeleteById throws an error if fails so we better return a boolean
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
