package com.example.demo.infraestructure.pizzaRepository;



import com.example.demo.domain.pizza.Pizza;
import com.example.demo.domain.pizza.PizzaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepositoryImp implements PizzaRepository {

    private final PizzaJPARepository pizzaJPARepository;// Relaciona la interfaz del JPA

    @Autowired
    public PizzaRepositoryImp(final PizzaJPARepository pizzaJPARepository) {
        this.pizzaJPARepository = pizzaJPARepository;
    }

    @Override
    public void add(Pizza pizza) {
        this.pizzaJPARepository.save(pizza);
    }

  
}
