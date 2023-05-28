package com.example.hw4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hw4.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}