package com.herokuapp.receptio.repository;

import com.herokuapp.receptio.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findAll();

    Optional<Recipe> findByName(String name);

}
