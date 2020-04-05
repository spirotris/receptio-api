package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(int idRecipe) {
        Optional<Recipe> result = recipeRepository.findById(idRecipe);
        return getRecipeEntryFromOptional(result);
    }

    @Override
    public Recipe findByName(String recipeName) {
        Optional<Recipe> result = recipeRepository.findByName(recipeName);
        return getRecipeEntryFromOptional(result);
    }

    @Override
    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(int idRecipe) {
        recipeRepository.deleteById(idRecipe);
    }

    private Recipe getRecipeEntryFromOptional(Optional<Recipe> recipe) {
        return recipe.orElse(null);
    }
}
