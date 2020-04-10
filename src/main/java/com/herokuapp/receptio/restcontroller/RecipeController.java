package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/")
    public ResponseEntity<List<Recipe>> searchRecipes(
            @RequestParam(value = "searchString", required = false) String recipeName) {

        List<Recipe> resultList;
        logger.info("/GET/ parameters: "+recipeName);

        if (!StringUtils.isEmpty(recipeName)) {
            logger.info("Attempting to find recipe by name: "+recipeName);
            resultList = recipeService.findAllByName(recipeName);
            logger.info("Hits from search: "+resultList.size());
        } else {
            resultList = recipeService.findAll();
        }

        return new ResponseEntity<List<Recipe>>(resultList, HttpStatus.OK);
    }

    @GetMapping("/{recipeId}")
    public Recipe getRecipeById(@PathVariable int recipeId) {
        return recipeService.findById(recipeId);
    }

    @PostMapping("/")
    public Recipe saveRecipe(@RequestBody @Valid Recipe recipe) {
        logger.info("Attempting to create recipe: "+recipe);
        return recipeService.save(recipe);
    }

    @PutMapping("/{recipeId}")
    public Recipe updateRecipe(@PathVariable int recipeId,
                               @RequestBody @Valid Recipe recipe) {
        recipe.setIdRecipe(recipeId);
        logger.info("Attempting to update recipe id: "+recipeId +"\nRecipe: "+recipe);

        return recipeService.save(recipe);
    }

    @PatchMapping("/{recipeId}")
    public Recipe partiallyUpdateRecipe(@PathVariable int recipeId,
                                        @RequestBody Recipe recipe) {
        recipe.setIdRecipe(recipeId);

        return recipeService.save(recipe);
    }

    @DeleteMapping("/{recipeId}")
    public String deleteRecipe(@PathVariable int recipeId) {
        recipeService.deleteById(recipeId);

        return "Deleted recipe with id: " + recipeId;
    }

}
