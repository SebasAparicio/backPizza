package com.example.demo.controller.PizzaController;

import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.application.pizzaApplication.PizzaApplication;
import com.example.demo.domain.pizza.PizzaDetail;
import com.example.demo.dto.CommentDTO.CommentDTO;
import com.example.demo.dto.CommentDTO.CreateCommentDTO;
import com.example.demo.dto.pizzaDTO.CreatePizzaDTO;
import com.example.demo.dto.pizzaDTO.PizzaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600) 
@RequestMapping("api/v1/pizzas")
public class PizzaController {
    private final PizzaApplication pizzaApplication;

    @Autowired
    public PizzaController(final PizzaApplication pizzaApplication) {
        this.pizzaApplication = pizzaApplication;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> create(@RequestBody final CreatePizzaDTO pizzaDTO) {
        PizzaDTO pizza = this.pizzaApplication.add(pizzaDTO);
        return ResponseEntity.status(201).body(pizza);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> get(@PathVariable UUID id) {
        PizzaDetail pizza = this.pizzaApplication.findDetail(id);
        return ResponseEntity.ok(pizza);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable UUID id) {
        this.pizzaApplication.delete(id);
    }

    @DeleteMapping(path = "/{pizzaId}/ingredients/{ingredientId}")
    void deleteIngredient(@PathVariable UUID pizzaId, @PathVariable UUID ingredientId) {
        this.pizzaApplication.deleteIngredient(pizzaId, ingredientId);
    }

    @PostMapping(path = "/{pizzaId}/comments", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> create(@PathVariable UUID pizzaId, @Valid @RequestBody final CreateCommentDTO commentDTO, Errors errors) throws NotFoundException {
        if (errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldErrors());
        }
        CommentDTO comment = this.pizzaApplication.addComment(pizzaId,commentDTO);
        return ResponseEntity.status(201).body(comment);
    }
    @GetMapping
        public ResponseEntity<?> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size)
            //TODO hacer parametro para lo de ascendete y descendente y poner un defaultValue=algo
             {
            return ResponseEntity.ok(this.pizzaApplication.findAll(name, page, size));
    }
}
