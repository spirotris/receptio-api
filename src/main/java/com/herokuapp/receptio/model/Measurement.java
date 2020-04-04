package com.herokuapp.receptio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="measurements")
@Data
public class Measurement {

    @Id
    @Column(name="idmeasurement")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column(name="measurement")
    private String measurement;

    @Override
    public String toString() {
        return measurement;
    }

}
