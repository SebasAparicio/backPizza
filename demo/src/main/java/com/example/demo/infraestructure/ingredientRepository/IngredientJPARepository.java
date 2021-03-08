package com.example.demo.infraestructure.ingredientRepository;

import java.util.UUID;

import com.example.demo.domain.ingredient.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientJPARepository extends JpaRepository<Ingredient, UUID> {
}
