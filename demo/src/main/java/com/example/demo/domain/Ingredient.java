package com.example.demo.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Ingredient {
    @Id
    @Type (type = "uid-char")
    public UUID id;

    @Column(nullable=false)
    public String name;
    
    @Column
    public double price;
}
