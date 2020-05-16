package com.herokuapp.receptio.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
public class Ingredient extends Entity {

    private String name;
    private String imageUrl;
    private String measurementType;
    private Double amount;

}
