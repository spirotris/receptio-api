package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Ingredient;
import com.herokuapp.receptio.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
@RequiredArgsConstructor
public class IngredientController {

    private Logger logger = LoggerFactory.getLogger(IngredientController.class);

    private final IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }

}
