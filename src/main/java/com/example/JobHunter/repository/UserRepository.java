package com.example.JobHunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JobHunter.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query methods can be defined here if needed

}
