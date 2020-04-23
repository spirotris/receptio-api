package com.herokuapp.receptio.repository;

import com.herokuapp.receptio.model.Recipe;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends Neo4jRepository<Recipe, Long> {

    List<Recipe> findAll();

    List<Recipe> findAllByNameContaining(String str);

    // TODO: Search after recipes by ingredients
    //List<Recipe> findAllByContainingAndIngredientsExists(List<Ingredient> ingredients);

}
