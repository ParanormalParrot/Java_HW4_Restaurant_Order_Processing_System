package com.example.order_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.order_service.Dish;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}