package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@NaturalIdCache
@Data
public class Ingredient {

    @Id
    @Column(name="idingredient")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int idIngredient;

    @Column(name = "name")
    private String name;

    @Column(name = "imageurl")
    private String imageUrl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "ingredient_measurements",
            joinColumns = {
                @JoinColumn(name = "idingredient", referencedColumnName = "idingredient") },
            inverseJoinColumns = {
                @JoinColumn(name="idmeasurement", referencedColumnName = "idmeasurement") })
    private Measurement measurement;

    @JsonInclude
    @Transient
    private double quantity;

    public String getMeasurement() {
        return measurement.toString();
    }

    int getIdIngredient() {
        return idIngredient;
    }
}
