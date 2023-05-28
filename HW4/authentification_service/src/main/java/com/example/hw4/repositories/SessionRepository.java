package com.example.hw4.repositories;

import com.example.hw4.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    Optional<Session> findBySessionToken(String token);
}