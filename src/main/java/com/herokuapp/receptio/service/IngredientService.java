package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> findByName(String name);

}
