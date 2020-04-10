package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipe_ingredients")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@IdClass(RecipeIngredientsId.class)
public class RecipeIngredients implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idrecipe")
    @JsonIgnore
    private Recipe recipe;

    @Id
    @ManyToOne
    @JoinColumn(name = "idingredient")
    @JsonUnwrapped
    private Ingredient ingredient;

}
