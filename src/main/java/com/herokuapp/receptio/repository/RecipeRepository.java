package com.herokuapp.receptio.repository;

import com.herokuapp.receptio.model.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findAll();

    Recipe findByName(String name);

    Recipe findById(int id);

    @Query("SELECT r FROM Recipe r WHERE r.name LIKE %?1%")
    List<Recipe> findAllByName(String str);

}
