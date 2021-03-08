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
    private Set<Ingredient> ingredients;
}
