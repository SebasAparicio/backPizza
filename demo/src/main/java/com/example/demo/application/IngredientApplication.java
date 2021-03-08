package com.example.demo.application;

import java.util.UUID;

import com.example.demo.dto.CreateIngredientDTO;
import com.example.demo.dto.IngredientDTO;

public interface IngredientApplication {
    public IngredientDTO add(CreateIngredientDTO dto);
    public IngredientDTO get(UUID id );
    public void update(UUID id,CreateIngredientDTO dto);
    public void delete(UUID id);
    
}
