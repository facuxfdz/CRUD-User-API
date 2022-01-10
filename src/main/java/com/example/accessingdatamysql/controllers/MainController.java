package com.example.accessingdatamysql.controllers;

import java.util.ArrayList;

import com.example.accessingdatamysql.models.User;
import com.example.accessingdatamysql.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a controller
@RequestMapping(path = "/demo") //  This means URL's start with /demo after app path
public class MainController {
    @Autowired // Allows us to use a service without instantiating it
    private UserService userService;

    @PostMapping(path = "/add") // Map POST requests
    public @ResponseBody User addNewUser (@RequestBody User user){
        // @ResponseBody means the returned String is the response and not a view name
        return userService.addUser(user);
    }

    @GetMapping(path = "/all")
    public @ResponseBody ArrayList<User> getAllUsers(){
        // This will return a JSON or XML with the users
        return userService.getUsers();
    }
}
