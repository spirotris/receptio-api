package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.exception.BadResourceException;
import com.herokuapp.receptio.exception.InvalidAuthorizationException;
import com.herokuapp.receptio.exception.ResourceNotFoundException;
import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
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
    public ResponseEntity<List<Recipe>> searchRecipesContainingName(
            @RequestParam(value = "name", required = false) String recipeName,
            @RequestParam(value = "ingredients", required = false) String ingredients,
            @RequestParam(value = "limit", required = false) Integer limit) {
        List<Recipe> resultList;
        if (limit == null) {
            limit = 100; // TODO: How to handle this?
        }

        if (!StringUtils.isEmpty(recipeName)) { // Recipe YES?
            resultList = recipeService.findRecipesByName(recipeName, limit);
            if (!StringUtils.isEmpty(ingredients)) { // Ingr YES?
                resultList = recipeService.findRecipesByNameAndIngredients(recipeName, ingredients, limit);
            }
        } else if (!StringUtils.isEmpty(ingredients) && StringUtils.isEmpty(recipeName)) { // Ingr YES, Recipe NO ?
            resultList = recipeService.findRecipesByIngredients(ingredients, limit);
        } else {
            resultList = recipeService.findAll(limit);
        }

        if (resultList.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping(path = "/{recipeId}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long recipeId) {
        Recipe recipe = recipeService.findById(recipeId);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Recipe> saveRecipe(@RequestBody @Valid Recipe recipe,
                                             @AuthenticationPrincipal Jwt jwt) {
        String user = jwt.getClaim("sub");
        recipe.setUser(user);
        Recipe result = recipeService.save(recipe);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PutMapping(path = "/{recipeId}", consumes = "application/json")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long recipeId,
                                               @RequestBody @Valid Recipe recipe,
                                               @AuthenticationPrincipal Jwt jwt) {
        String user = jwt.getClaim("sub");
        recipe.setId(recipeId);
        recipe.setUser(user);
        Recipe result = recipeService.save(recipe);
        if (recipe.equals(result)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PatchMapping(path = "/{recipeId}", consumes = "application/json")
    public ResponseEntity<Recipe> partiallyUpdateRecipe(@PathVariable Long recipeId,
                                                        @RequestBody Recipe recipe,
                                                        @AuthenticationPrincipal Jwt jwt) {
        String user = jwt.getClaim("sub");
        recipe.setId(recipeId);
        recipe.setUser(user);
        Recipe result = recipeService.save(recipe);
        if (recipe.equals(result)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{recipeId}")
    public ResponseEntity deleteRecipe(@PathVariable Long recipeId,
                                       @AuthenticationPrincipal Jwt jwt) {
        String user = jwt.getClaim("sub");
        recipeService.deleteById(recipeId, user);
        return new ResponseEntity(HttpStatus.OK);

    }

}