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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a controller
@RequestMapping(path = "/users") // This means URL's start with /demo after app path
public class MainController {
    @Autowired // Allows us to use a service without instantiating it
    private UserService userService;

    @PostMapping
    public @ResponseBody User addNewUser(@RequestBody User user) {
        // @ResponseBody means the returned String is the response and not a view name
        return userService.addUser(user);
    }

    @GetMapping
    public @ResponseBody ArrayList<User> getAllUsers() {
        // This will return a JSON or XML with the users
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUserById(@PathVariable Integer id){
        boolean deleteQueryOk = userService.deleteUser(id);
        if(deleteQueryOk){
            return "User with id \"" + id + "\" successfully deleted";
        }

        return "Something went wrong";
    }

}
