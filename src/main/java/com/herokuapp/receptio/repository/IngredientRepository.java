package com.herokuapp.receptio.repository;

import com.herokuapp.receptio.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    List<Ingredient> findAll();

    List<Ingredient> findAllByName(String name);

    Ingredient findById(int id);

}


