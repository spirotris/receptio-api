package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ingredient_measurements")
@Data
@IdClass(IngredientMeasurementsId.class)
public class IngredientMeasurements implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "idingredient")
    @JsonIgnore
    private Ingredient ingredient;

    @Id
    @OneToOne
    @JoinColumn(name = "idmeasurement")
    @JsonIgnore
    private Measurement measurement;

}