package com.example.demo.application.pizzaApplication;




import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;





public interface PizzaApplication {
    public PizzaDTO add(CreatePizzaDTO pizzaDTO);
    
}
