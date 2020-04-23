package com.herokuapp.receptio.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Data
public class Recipe extends Entity {

    private String name;
    private String description;
    private int cookingTime;
    private int servings;
    private String instructions;

    @Relationship(type = "NEEDS", direction = Relationship.INCOMING)
    private List<Ingredient> ingredients;

    private String imageUrl;
    private String author;

}
