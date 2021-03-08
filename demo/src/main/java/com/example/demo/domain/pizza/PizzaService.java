package com.example.demo.domain.pizza;

import java.util.UUID;

import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;

public class PizzaService {
    public static Pizza create(CreatePizzaDTO pizzaDTO){
        Pizza pizza = new Pizza();
        pizza.name = pizzaDTO.name;
        pizza.id = UUID.randomUUID();
        return pizza;
    }
    public static PizzaDTO createDTO(Pizza pizza){
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.id = pizza.id;
        pizzaDTO.name = pizza.name;
        pizzaDTO.price = pizza.price;
        //TODO: convertir el ingrediente del dominio a PizzaIngredienteDTO
        return pizzaDTO;
    }
}
