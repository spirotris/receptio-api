package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "recipes")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idRecipe")
public class Recipe implements Serializable {

    @Id
    @Column(name = "idrecipe")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecipe;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cookingtime")
    private Integer cookingTime;

    @Column(name = "servings")
    private Integer servings;

    @Column(name = "instructions")
    private String instructions;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="recipe_ingredients",
            joinColumns =
                    { @JoinColumn(name="idrecipe", referencedColumnName ="idrecipe") },
            inverseJoinColumns =
                    { @JoinColumn(name="idingredient", referencedColumnName =  "idingredient")})
    @JsonUnwrapped
    private List<Ingredient> ingredients;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "author")
    private String author;

}
