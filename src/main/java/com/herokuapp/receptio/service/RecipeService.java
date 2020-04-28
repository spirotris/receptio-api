package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll();

    Recipe findById(Long idRecipe);

    Recipe save(Recipe recipe);

    void deleteById(Long idRecipe);

    List<Recipe> findRecipesByNameContaining(String searchString);

    List<Recipe> findRecipesByIngredientsContains(String ingredients);

}
