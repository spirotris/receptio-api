package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Recipe;
import com.herokuapp.receptio.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final RecipeService recipeService;

    @GetMapping("/recipe")
    public ResponseEntity<List<Recipe>> getUserRecipes(@AuthenticationPrincipal Jwt jwt) {
        String userId = jwt.getClaim("sub");
        List<Recipe> recipes = recipeService.findRecipesByUser(userId);
        return new ResponseEntity<>(recipes, HttpStatus.OK);
    }
}
