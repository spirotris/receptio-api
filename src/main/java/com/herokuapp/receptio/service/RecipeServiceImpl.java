package com.herokuapp.receptio.service;

import com.herokuapp.receptio.exception.BadResourceException;
import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.repository.RecipeRepository;
import com.herokuapp.receptio.exception.InvalidAuthorizationException;
import com.herokuapp.receptio.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<Recipe> findAll(int limit) {
        return recipeRepository.findAll(limit);
    }

    @Override
    public Recipe findById(Long idRecipe) throws ResourceNotFoundException {
        Recipe recipe = null;
        Optional<Recipe> result = recipeRepository.findById(idRecipe);
        if (result.isPresent()) {
            recipe = result.get();
        } else {
            throw new ResourceNotFoundException("Did not find recipe with ID: " + idRecipe);
        }
        return recipe;
    }

    @Override
    public Recipe save(Recipe recipe) throws BadResourceException {
        Recipe result = null;
        if(!StringUtils.isEmpty(recipe.getUser())) {
            result = recipeRepository.save(recipe);
        } else {
            throw new BadResourceException("User cannot be null.");
        }
        return result;
    }

    @Override
    public Recipe update(Recipe recipe) throws ResourceNotFoundException, InvalidAuthorizationException {
        String existingRecipeUser = findById(recipe.getId()).getUser();
        String user = recipe.getUser();

        if (!user.equals(existingRecipeUser)) {
            throw new InvalidAuthorizationException();
        } else {
            return recipeRepository.save(recipe);
        }
    }

    @Override
    public void deleteById(Long idRecipe, String user) throws ResourceNotFoundException, InvalidAuthorizationException {
        try {
            Recipe tempRecipe = findById(idRecipe);
            if (tempRecipe.getUser().equals(user)) {
                recipeRepository.deleteById(idRecipe);
            } else {
                throw new InvalidAuthorizationException();
            }
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("No resource found with ID: " + idRecipe);
        }

    }

    @Override
    public List<Recipe> findRecipesByName(String recipeName, int limit) {
        logger.info("Attempting to find recipes with searchString: " + recipeName);
        return recipeRepository.findRecipesByNameContainsIgnoreCase(recipeName, limit);
    }

    @Override
    public List<Recipe> findRecipesByIngredients(String ingredients, int limit) {
        List<String> ingredientList = Stream.of(ingredients.split(",")).map(String::trim).collect(Collectors.toList());
        logger.info("Attempting to find recipes with ingredients: " + Arrays.toString(ingredientList.toArray()));
        return recipeRepository.findAllByIngredientsNameContainsAllIgnoreCase(ingredientList, limit);
    }

    @Override
    public List<Recipe> findRecipesByNameAndIngredients(String recipeName, String ingredients, int limit) {
        List<String> ingredientList = Stream.of(ingredients.split(",")).map(String::trim).collect(Collectors.toList());
        logger.info("Attempting to find recipes with ingredients: " + Arrays.toString(ingredientList.toArray()));
        logger.info("Attempting to find recipes with recipeName: " + recipeName);
        return recipeRepository.findRecipesByNameContainsAndIngredientsNameContainingAllIgnoreCase(recipeName, ingredientList, limit);
    }

    @Override
    public List<Recipe> findRecipesByUser(String userId) {
        return recipeRepository.findAllByUser(userId);
    }

}
