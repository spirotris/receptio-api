package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "measurements")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMeasurement")
public class Measurement {

    @Id
    @Column(name = "idmeasurement", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMeasurement;

    @Column(name = "measurement")
    private String measurement;

    @Override
    public String toString() {
        return measurement;
    }

}
