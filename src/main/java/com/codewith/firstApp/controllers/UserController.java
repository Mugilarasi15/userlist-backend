package com.codewith.firstApp.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.*;

import com.codewith.firstApp.model.User;
import com.codewith.firstApp.service.Userservice;

@CrossOrigin(origins = {
	    "http://localhost:5173",
	    "https://mugilarasi15.github.io"
	})
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Userservice userservice;

    public UserController(Userservice userservice) {
        this.userservice = userservice;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userservice.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userservice.addUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {
        return userservice.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userservice.deleteUser(id);
    }
}