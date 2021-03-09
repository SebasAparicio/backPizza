package com.example.demo.application.pizzaApplication;




import java.util.UUID;

import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;





public interface PizzaApplication {
    public PizzaDTO add(CreatePizzaDTO pizzaDTO);
    public PizzaDTO get(UUID id);
    public void update(UUID id, CreatePizzaDTO pizzaDTO);
    public void delete(UUID id);
    public void deleteIngredient(UUID pizzaId, UUID ingredientId);
}
