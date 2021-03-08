package com.example.demo.application;

import java.util.UUID;

import com.example.demo.domain.Ingredient;
import com.example.demo.domain.IngredientRepository;
import com.example.demo.domain.IngredientService;
import com.example.demo.dto.CreateIngredientDTO;
import com.example.demo.dto.IngredientDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientApplicationImp implements IngredientApplication {
    
    private final IngredientRepository ingredientRepository; //esto relaciona la interfaz de la infraestructura

    @Autowired
    public IngredientApplicationImp(final IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO add(CreateIngredientDTO dto){
        //Input
        Ingredient ingredient = IngredientService.create(dto);
        this.ingredientRepository.add(ingredient);
        //Output
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public void update(UUID id, CreateIngredientDTO dto) {        
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        this.ingredientRepository.update(ingredient);
    }

    @Override
    public IngredientDTO get(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        return IngredientService.createDTO(ingredient);
    }

    @Override
    public void delete(UUID id) {
        Ingredient ingredient = this.ingredientRepository.findById(id).orElseThrow();
        this.ingredientRepository.delete(ingredient);
    }
    
}
