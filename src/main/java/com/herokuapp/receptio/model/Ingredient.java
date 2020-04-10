package com.herokuapp.receptio.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties("hibernateLazyInitializer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idIngredient")
public class Ingredient implements Serializable {

    @Id
    @Column(name = "idingredient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngredient;

    @Column(name = "name")
    private String name;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name="amount")
    private Double amount;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinTable(name="ingredient_measurements",
            joinColumns =
                    { @JoinColumn(name="idingredient", referencedColumnName ="idingredient") },
            inverseJoinColumns =
                    { @JoinColumn(name="idmeasurement", referencedColumnName =  "idmeasurement")})
    @JsonUnwrapped
    private Measurement measurement;

}
