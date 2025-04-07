package com.example.JobHunter.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.JobHunter.domain.User;
import com.example.JobHunter.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        this.userService.handleSaveUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        this.userService.handleDeleteUser(id);
        return "User deleted successfully";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return this.userService.fetchUserById(id);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return this.userService.fetchAllUsers();
    }

    @PutMapping("user")
    public User updateUser(@RequestBody User user) {
        // TODO: process PUT request
        User userUpdate = this.userService.handleUpdateUser(user);
        return userUpdate;
    }
}
