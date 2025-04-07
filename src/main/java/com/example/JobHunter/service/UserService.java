package com.example.JobHunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.JobHunter.domain.User;
import com.example.JobHunter.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void handleSaveUser(User user) {
        // Logic to save the user to the database
        // For example, using a UserRepository to save the user entity
        this.userRepository.save(user);
    }

    public void handleDeleteUser(Long id) {
        // Logic to delete the user from the database
        // For example, using a UserRepository to delete the user entity by ID
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(Long id) {
        // TODO Auto-generated method stub
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            // Handle the case when the user is not found
            // For example, throw an exception or return null
            return null; // or throw new UserNotFoundException("User not found with id: " + id);
        }
    }

    public List<User> fetchAllUsers() {
        // TODO Auto-generated method stub
        return this.userRepository.findAll();
    }

    public User handleUpdateUser(User user) {
        // Logic to update the user in the database
        // For example, using a UserRepository to save the updated user entity
        User updateUser = this.fetchUserById(user.getId());
        if (updateUser != null) {
            updateUser.setName(user.getName());
            updateUser.setEmail(user.getEmail());
            updateUser.setPassword(user.getPassword());

            // update
            updateUser = this.userRepository.save(user);
        }
        return updateUser;
    }
}
