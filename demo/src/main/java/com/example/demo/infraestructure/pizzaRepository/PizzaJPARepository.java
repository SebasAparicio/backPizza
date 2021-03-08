package com.example.demo.infraestructure.pizzaRepository;

import java.util.UUID;

import com.example.demo.domain.pizza.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaJPARepository extends JpaRepository<Pizza, UUID> {
    }
