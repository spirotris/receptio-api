package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(int idRecipe) {
        return recipeRepository.findById(idRecipe);
    }

    @Override
    public Recipe findByName(String recipeName) {
        return recipeRepository.findByName(recipeName);
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(int idRecipe) {
        recipeRepository.deleteById(idRecipe);
    }

    @Override
    public List<Recipe> findAllByName(String searchString) {
        return recipeRepository.findAllByName(searchString);
    }
}
