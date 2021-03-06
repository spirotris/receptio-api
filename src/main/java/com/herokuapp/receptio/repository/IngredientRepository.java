package com.herokuapp.receptio.repository;

import com.herokuapp.receptio.model.Ingredient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends Neo4jRepository<Ingredient, Long> {

    List<Ingredient> findAll();

}


