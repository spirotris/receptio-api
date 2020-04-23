package com.herokuapp.receptio.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

@Data
abstract class Entity {

    @Id
    @GeneratedValue
    private Long id;

}
