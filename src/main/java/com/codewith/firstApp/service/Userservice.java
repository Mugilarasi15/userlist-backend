package com.codewith.firstApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codewith.firstApp.model.User;
import com.codewith.firstApp.Repository.UserRepository;

@Service
public class Userservice {

    private final UserRepository userRepository;

    public Userservice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existing = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());

        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
