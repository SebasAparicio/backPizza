package com.example.demo.infraestructure;

import java.util.UUID;
import com.example.demo.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientJPARepository extends JpaRepository<Ingredient, UUID> {
}
