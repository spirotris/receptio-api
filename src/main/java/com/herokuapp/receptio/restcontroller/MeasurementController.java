package com.herokuapp.receptio.restcontroller;

import com.herokuapp.receptio.model.Ingredient;
import com.herokuapp.receptio.model.Measurement;
import com.herokuapp.receptio.service.IngredientService;
import com.herokuapp.receptio.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/measurement")
@RequiredArgsConstructor
public class MeasurementController {

    private Logger logger = LoggerFactory.getLogger(MeasurementController.class);

    private final IngredientService ingredientService;

    @GetMapping
    public List<Measurement> getAllMeasurements() {
        List<Ingredient> ingredients = ingredientService.findAll();
        List<Measurement> measurements = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getMeasurementType() != null) {
                Measurement tempMeasurement = new Measurement(ingredient.getMeasurementType());
                measurements.add(tempMeasurement);
            }
        }
        return measurements;
    }

}
