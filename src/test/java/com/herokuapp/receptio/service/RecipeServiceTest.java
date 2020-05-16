package com.herokuapp.receptio.service;

import com.herokuapp.receptio.exception.ResourceNotFoundException;
import com.herokuapp.receptio.model.Ingredient;
import com.herokuapp.receptio.model.Recipe;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WithMockUser
@Transactional
public class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @BeforeAll
    public void setUp() {
        Recipe recipe = new Recipe();
        recipe.setName("test");

        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient firstIngredient = new Ingredient();
        firstIngredient.setName("test");
        firstIngredient.setMeasurementType("test");
        firstIngredient.setImageUrl("test");
        firstIngredient.setAmount(1.0);

        Ingredient secondIngredient = new Ingredient();
        secondIngredient.setName("strange name");

        ingredients.add(firstIngredient);
        ingredients.add(secondIngredient);

        recipe.setIngredients(ingredients);
        recipeService.save(recipe);
    }

    @Test
    public void repositorySavesRecipe() {
        Recipe recipe = new Recipe();
        recipe.setName("test");

        Recipe result = recipeService.save(recipe);

        assertNotNull(result);
        assertEquals("test", result.getName());
    }

    @Test
    public void repositoryDeletesRecipes() {
        Recipe recipe = new Recipe();
        recipe.setName("testRecipe");
        recipe.setUser("test");
        Recipe result = recipeService.save(recipe);

        assertNotNull(result);

        Long id = result.getId();
        String user = result.getUser();
        recipeService.deleteById(id, user);

        assertThrows(ResourceNotFoundException.class, () -> {
            recipeService.findById(id);
        });
    }

    @Test
    public void repositorySavesIngredients() {
        List<Recipe> recipeList = recipeService.findRecipesByName("test", 0);
        List<Ingredient> ingredientList = recipeList.get(0).getIngredients();
        Ingredient ingredient = ingredientList.get(0);

        assertNotNull(ingredient);
    }

    @Test
    public void repositorySuccessfullyReturnsPartialNamesInSearch() {
        List<Recipe> recipeList = recipeService.findRecipesByName("est", 0);
        assertNotNull(recipeList.get(0).getName());
    }


}
