package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@JsonIgnoreProperties(value="id")
public class Measurement extends Entity {

    private String measurementType;

    public Measurement(String measurementType) {
        this.measurementType = measurementType;
    }
}
