package com.herokuapp.receptio.repository;

import com.herokuapp.receptio.model.Measurement;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends Neo4jRepository<Measurement, Long> {

    List<Measurement> findAll();

}


