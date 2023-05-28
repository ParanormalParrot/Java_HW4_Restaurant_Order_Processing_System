package com.example.order_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order_service.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Integer> {
    Optional<List<Dish>> findByIsAvailable(Boolean available);
}