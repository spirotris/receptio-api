package com.herokuapp.receptio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data @NoArgsConstructor
public class RecipeIngredientsId implements Serializable {

    private Recipe recipe;

    private Ingredient ingredient;

    RecipeIngredientsId(Recipe recipe, Ingredient ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredientsId that = (RecipeIngredientsId) o;
        return recipe == that.recipe &&
                ingredient == that.ingredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe, ingredient);
    }
}