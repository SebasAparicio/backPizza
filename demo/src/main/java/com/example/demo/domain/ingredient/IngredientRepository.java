package com.example.demo.domain.ingredient;

import java.util.Optional;
import java.util.UUID;

public interface IngredientRepository {
    public void add(Ingredient ingredient);
    public void update(Ingredient ingredient);
    public void delete(Ingredient ingredient);
    public Optional<Ingredient> findById(UUID id); 

}
