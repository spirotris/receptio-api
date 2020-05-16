package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Ingredient;
import com.herokuapp.receptio.model.Measurement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {

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
        return measurements.stream().distinct().collect(Collectors.toList());
    }

}
