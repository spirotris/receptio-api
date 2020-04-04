package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/")
    public ResponseEntity<List<Recipe>> searchRecipes(
            @RequestParam(value = "id", required = false) Integer recipeId,
            @RequestParam(value = "searchString", required = false) String searchString,
            @RequestParam(value = "servings", required = false) Integer servings,
            @RequestParam(value = "resultLimit", required = false) Integer resultLimit) {

        List<Recipe> recipes = new ArrayList<>();

        if(recipeId != null) {
            recipes.add(recipeService.findById(recipeId, servings));
            return new ResponseEntity<>(recipes, HttpStatus.OK);
        }

        recipes.addAll(recipeService.findAll());

        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }

}
