package com.herokuapp.receptio.repository;

import com.herokuapp.receptio.model.Recipe;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends Neo4jRepository<Recipe, Long> {

    List<Recipe> findAll(int limit);

    List<Recipe> findRecipesByNameContainsIgnoreCase(String str, int limit);

    List<Recipe> findAllByIngredientsNameContainsAllIgnoreCase(List<String> ingredients, int limit);

    List<Recipe> findRecipesByNameContainsAndIngredientsNameContainingAllIgnoreCase(String name, List<String> ingredients, int limit);

    List<Recipe> findAllByUser(String userId);
}
