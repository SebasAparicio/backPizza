package com.example.demo.application.pizzaApplication;

import java.util.UUID;

import com.example.demo.domain.ingredient.IngredientRepository;
import com.example.demo.domain.pizza.Pizza;
import com.example.demo.domain.pizza.PizzaRepository;
import com.example.demo.domain.pizza.PizzaService;
import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaApplicationImp implements PizzaApplication {

    private final PizzaRepository pizzaRepository;
    private final IngredientRepository ingredientRepository;
    @Autowired
    public PizzaApplicationImp (final PizzaRepository pizzaRepository, final IngredientRepository ingredientRepository){
        this.pizzaRepository = pizzaRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public PizzaDTO add(CreatePizzaDTO pizzaDTO) {
        Pizza pizza = PizzaService.create(pizzaDTO);
        //TODO: por cada ingrediente del DTO leer el ingrediente y agregarlo a la pizza
        this.pizzaRepository.add(pizza);
        return PizzaService.createDTO(pizza);
    }

}
