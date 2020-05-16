package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll(int limit);

    Recipe findById(Long idRecipe);

    Recipe save(Recipe recipe);

    Recipe update(Recipe recipe);

    void deleteById(Long idRecipe, String user);

    List<Recipe> findRecipesByName(String searchString, int limit);

    List<Recipe> findRecipesByIngredients(String ingredients, int limit);

    List<Recipe> findRecipesByNameAndIngredients(String recipeName, String ingredients, int limit);

    List<Recipe> findRecipesByUser(String userId);
}
