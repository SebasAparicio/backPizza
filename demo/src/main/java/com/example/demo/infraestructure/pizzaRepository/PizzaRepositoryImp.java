package com.example.demo.infraestructure.pizzaRepository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public void update(Pizza pizza) {
        this.pizzaJPARepository.save(pizza);

    }

    @Override
    public void delete(Pizza pizza) {
        this.pizzaJPARepository.delete(pizza);

    }

    @Override
    public Optional<Pizza> findById(UUID id) {
        return this.pizzaJPARepository.findById(id);
    }
    
}
