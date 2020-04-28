package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private Logger logger = LoggerFactory.getLogger(RecipeController.class);

    private final RecipeService recipeService;

    @GetMapping
    public List<Recipe> searchRecipesContainingName(
            @RequestParam(value = "name", required = false) String recipeName,
            @RequestParam(value = "ingredients", required = false) String ingredients,
            @RequestParam(value = "limit", required = false) Integer limit) {

        List<Recipe> resultList;

        if (!StringUtils.isEmpty(recipeName)) {
            resultList = recipeService.findRecipesByNameContaining(recipeName);
            if (!StringUtils.isEmpty(ingredients)) {
                resultList = recipeService.findRecipesByIngredientsContains(ingredients);
            }
        } else if(!StringUtils.isEmpty(ingredients)) {
            resultList = recipeService.findRecipesByIngredientsContains(ingredients);
        } else {
            resultList = recipeService.findAll();
        }

        return resultList;
    }

    @GetMapping("/{recipeId}")
    public Recipe getRecipeById(@PathVariable Long recipeId) {
        return recipeService.findById(recipeId);
    }

    @PostMapping
    public Recipe saveRecipe(@RequestBody @Valid Recipe recipe) {
        logger.info("Attempting to create recipe: " + recipe);
        return recipeService.save(recipe);
    }

    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@PathVariable Long recipeId,
                               @RequestBody @Valid Recipe recipe) {
        recipe.setId(recipeId);
        logger.info("Attempting to update recipe id: " + recipeId + "\nRecipe: " + recipe);

        return recipeService.save(recipe);
    }

    @PatchMapping("/{recipeId}")
    public Recipe partiallyUpdateRecipe(@PathVariable Long recipeId,
                                        @RequestBody Recipe recipe) {
        recipe.setId(recipeId);

        return recipeService.save(recipe);
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) {
        recipeService.deleteById(recipeId);

        return "Deleted recipe with id: " + recipeId;
    }

}
