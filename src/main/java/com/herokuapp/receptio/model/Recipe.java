package com.herokuapp.receptio.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "recipes")
@Data
public class Recipe {

    @Id
    @Column(name = "idrecipe")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int idRecipe;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="cookingtime")
    private int cookingTime;

    @Column(name="servings")
    private int servings;

    @Column(name="instructions")
    private String instructions;

    @OneToMany
    @JoinTable(name = "recipe_ingredients",
            joinColumns = {
                @JoinColumn(name = "idrecipe", referencedColumnName = "idrecipe")},
            inverseJoinColumns = {
                @JoinColumn(name = "idingredient", referencedColumnName = "idingredient")})
    private List<Ingredient> ingredients;


    @Column(name="imageurl")
    private String imageUrl;

    @Column(name="author")
    private String author;

    int getIdRecipe() {
        return idRecipe;
    }

}
