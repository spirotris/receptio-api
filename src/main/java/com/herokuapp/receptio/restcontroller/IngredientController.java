package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Ingredient;
import com.herokuapp.receptio.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @GetMapping("/")
    public ResponseEntity<List<Ingredient>> searchIngredients() {
        return new ResponseEntity<>(ingredientService.findByName("cheese"), HttpStatus.OK);
    }
}
