package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> findAll();

    Recipe findById(int idRecipe);

    Recipe findByName(String recipeName);

    void save(Recipe recipe);

    void deleteById(int idRecipe);

}
