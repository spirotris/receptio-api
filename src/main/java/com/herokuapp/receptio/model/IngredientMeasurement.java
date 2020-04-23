package com.herokuapp.receptio.model;

import lombok.Data;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="USES")
@Data
public class IngredientMeasurement extends Entity {

    @StartNode
    private Ingredient ingredient;

    @EndNode
    private Measurement measurement;

}
