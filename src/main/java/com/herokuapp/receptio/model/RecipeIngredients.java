package com.herokuapp.receptio.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="recipe_ingredients")
@Data
public class RecipeIngredients {

    @EmbeddedId
    private RecipeIngredientsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idrecipe")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idingredient")
    private Ingredient ingredient;

    @Column(name="quantity")
    private double quantity;

    public RecipeIngredients(Recipe recipe, Ingredient ingredient) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.id = new RecipeIngredientsId(recipe.getIdRecipe(), ingredient.getIdIngredient());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredients that = (RecipeIngredients) o;
        return recipe == that.recipe &&
                ingredient == that.ingredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipe, ingredient);
    }
}
