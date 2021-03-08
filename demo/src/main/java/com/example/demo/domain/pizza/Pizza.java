package com.example.demo.domain.pizza;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.demo.domain.ingredient.Ingredient;

import org.hibernate.annotations.Type;

@Entity 
public class Pizza {
    @Id
    @Type (type = "uuid-char")
    public UUID id;

    @Column(nullable=false, unique = true)
    public String name;
    
    @Column
    public double price;
    
    @ManyToMany 
    //Si lo pongo private y solo cojo lo de ingredients no podria utilizarlo en service porque seria private
    //Por eso hacemos los metodos, ya que en el dominio se tiene que poner toda la logica interna de la pizza
    private Set<Ingredient> ingredients;

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
    }
}
