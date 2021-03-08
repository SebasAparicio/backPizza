package com.example.demo.infraestructure;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.example.demo.domain.Ingredient;
import com.example.demo.domain.IngredientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {
    
    private final IngredientJPARepository ingredientJPARepository;//Relaciona la interfaz del JPA
    
    @Autowired
    public IngredientRepositoryImp(final IngredientJPARepository ingredientJPARepository){
        this.ingredientJPARepository = ingredientJPARepository;
    }
    //Se implementa los metodos definidos en la interfaz
    public void add(Ingredient ingredient){
        this.ingredientJPARepository.save(ingredient);
    }
    public void update(Ingredient ingredient){
        this.ingredientJPARepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        this.ingredientJPARepository.delete(ingredient);

    }

    @Override
    public Optional<Ingredient> findById(UUID id) {
        return this.ingredientJPARepository.findById(id);
    }
    
}
