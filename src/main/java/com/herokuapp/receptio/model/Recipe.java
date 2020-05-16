package com.herokuapp.receptio.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotNull;
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

    @CreatedBy
    @NotNull
    private String user;

    @CreatedDate
    private Long createdDate;

    @LastModifiedDate
    private Long modifiedDate;

}
