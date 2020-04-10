package com.herokuapp.receptio.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data @NoArgsConstructor
public class IngredientMeasurementsId implements Serializable {

    private Ingredient ingredient;

    private Measurement measurement;

    public IngredientMeasurementsId(Ingredient ingredient, Measurement measurement) {
        this.ingredient = ingredient;
        this.measurement = measurement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientMeasurementsId that = (IngredientMeasurementsId) o;
        return ingredient.equals(that.ingredient) &&
                measurement.equals(that.measurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredient, measurement);
    }
}