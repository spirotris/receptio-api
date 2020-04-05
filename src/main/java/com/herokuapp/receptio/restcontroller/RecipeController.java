package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/")
    public List<Recipe> searchRecipes() {

        List<Recipe> recipes = recipeService.findAll();

        return recipes;
    }

    @GetMapping("/{recipeId}")
    public Recipe getRecipeById(@PathVariable int recipeId) {
        return recipeService.findById(recipeId);
    }

    @PostMapping("/")
    public String saveRecipe(@RequestBody Recipe recipe) {
        System.out.println("Attempting to save recipe: "+recipe);
        recipeService.save(recipe);
        return "Added recipe+: " + recipe;
    }

    @PutMapping("/{recipeId}")
    public String updateRecipe(@PathVariable int recipeId, @RequestBody Recipe recipe) {
        recipe.setIdRecipe(recipeId);

        recipeService.save(recipe);

        return "Updated recipe: " + recipe;
    }

    @PatchMapping("/{recipeId}")
    public String partiallyUpdateRecipe(@PathVariable int recipeId, @RequestBody Recipe recipe) {
        recipe.setIdRecipe(recipeId);

        recipeService.save(recipe);

        return "Updated recipe: " + recipe;
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable int recipeId) {
        recipeService.deleteById(recipeId);

        return "Deleted recipe with id: " + recipeId;
    }

}
