package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recipe_ingredients")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@IdClass(RecipeIngredientsId.class)
public class RecipeIngredients {

    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idrecipe", updatable = false, nullable = false)
    @JsonIgnore
    private Recipe recipe;

    @Id
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idingredient", updatable = false, nullable = false)
    @JsonUnwrapped
    private Ingredient ingredient;

    @Column(name="quantity")
    private Double quantity;

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
