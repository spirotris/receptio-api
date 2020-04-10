package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "measurements")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Measurement implements Serializable {

    @Id
    @Column(name = "idmeasurement")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer idMeasurement;

    @Column(name = "measurement")
    private String measurementType;


}
