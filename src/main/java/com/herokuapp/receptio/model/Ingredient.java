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
    @Column(name = "idingredient", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIngredient;

    @Column(name = "name")
    private String name;

    @Column(name = "imageurl")
    private String imageUrl;

    @OneToOne
    @JoinTable(name="ingredient_measurements",
            joinColumns =
                    { @JoinColumn(name="idingredient", referencedColumnName ="idingredient") },
            inverseJoinColumns =
                    { @JoinColumn(name="idmeasurement", referencedColumnName =  "idmeasurement") })
    private Measurement measurement;

    @JsonIgnore
    @OneToMany(mappedBy = "ingredient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<RecipeIngredients> recipeIngredients;

    public String getMeasurement() {
        return measurement.toString();
    }

}
