package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Ingredient;
import com.herokuapp.receptio.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private Logger logger = LoggerFactory.getLogger(IngredientController.class);

    private final IngredientService ingredientService;

    @GetMapping("/")
    public ResponseEntity<List<Ingredient>> searchIngredients() {
        return new ResponseEntity<>(ingredientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Ingredient getIngredient(@PathVariable int id) {
        return ingredientService.findById(id);
    }

    @PostMapping("/")
    public Ingredient saveIngredient(@RequestBody @Valid Ingredient ingredient) {
        logger.info("Attempting to save ingredient: " + ingredient);
        return ingredientService.save(ingredient);
    }
}
