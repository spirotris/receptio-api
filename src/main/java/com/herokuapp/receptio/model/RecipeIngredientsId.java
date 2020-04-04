package com.herokuapp.receptio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class RecipeIngredientsId implements Serializable {

    @Column(name = "idrecipe")
    private int idRecipe;

    @Column(name = "idingredient")
    private int idIngredient;

    RecipeIngredientsId(int idRecipe, int idIngredient) {
        this.idRecipe = idRecipe;
        this.idIngredient = idIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredientsId that = (RecipeIngredientsId) o;
        return idRecipe == that.idRecipe &&
                idIngredient == that.idIngredient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRecipe, idIngredient);
    }
}
