package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe findById(Long idRecipe) {
        Recipe recipe = null;
        Optional<Recipe> result = recipeRepository.findById(idRecipe);
        if (result.isPresent()) {
            recipe = result.get();
        }
        return recipe;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void deleteById(Long idRecipe) {
        recipeRepository.deleteById(idRecipe);
    }

    @Override
    public List<Recipe> findRecipesByNameContaining(String searchString) {
        return recipeRepository.findRecipesByNameContainsIgnoreCase(searchString);
    }

    @Override
    public List<Recipe> findRecipesByIngredientsContains(String ingredients) {
        List<String> ingredientList = Stream.of(ingredients.split(",")).map(String::trim).collect(Collectors.toList());
        return recipeRepository.findAllByIngredientsNameContainsIgnoreCase(ingredientList);
    }

}
