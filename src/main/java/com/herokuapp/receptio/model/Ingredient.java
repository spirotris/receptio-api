package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
@JsonIgnoreProperties(value="id")
public class Ingredient extends Entity {

    private String name;
    private String imageUrl;

    @Relationship(type="USES", direction = Relationship.INCOMING)
    private String measurementType;

    private Double amount;

}
