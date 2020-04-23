package com.herokuapp.receptio.model;

import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="NEEDS")
@Data
public class RecipeIngredient extends Entity {

    @StartNode
    private Recipe recipe;

    @EndNode
    private Ingredient ingredient;

}
