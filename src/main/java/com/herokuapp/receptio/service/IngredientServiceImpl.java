package com.herokuapp.receptio.service;

import com.herokuapp.receptio.model.Ingredient;
import com.herokuapp.receptio.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> findAllByName(String name) {
        return ingredientRepository.findAllByName(name);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient findById(int id) {
        return ingredientRepository.findById(id);
    }

}
