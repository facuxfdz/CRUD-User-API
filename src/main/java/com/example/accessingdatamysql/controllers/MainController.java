package com.example.accessingdatamysql.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.accessingdatamysql.models.User;
import com.example.accessingdatamysql.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller // This means that this class is a controller
@RequestMapping(path = "/users") // This means URL's start with /users after app path
public class MainController {
    @Autowired // Allows us to use a service without instantiating it
    private UserService userService; // We sill make our CRUD operations via our userService. In this case is something very simple but it could have any kind of complicated logic inside 
    
    @PostMapping
    public User addNewUser(@RequestBody User user) {
        // @ResponseBody means the returned User is the response and not a view name
        return userService.addUser(user);
    }

    @GetMapping
    public ArrayList<User> getAllUsers() {
        // This will return an array of JSON or XML with all users
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        // This will return either the user found or null if search doesn't resolve well
        return userService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable Integer id){
        boolean deleteQueryOk = userService.deleteUser(id);
        if(deleteQueryOk){
            return "User with id \"" + id + "\" successfully deleted";
        }

        return "Something went wrong";
    }

}
