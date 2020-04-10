package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll();

    Recipe findById(int idRecipe);

    Recipe findByName(String recipeName);

    Recipe save(Recipe recipe);

    void deleteById(int idRecipe);

    List<Recipe> findAllByName(String searchString);
}
