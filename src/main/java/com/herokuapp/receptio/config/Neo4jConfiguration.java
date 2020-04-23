package com.herokuapp.receptio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@Configuration
@EnableNeo4jRepositories(basePackages = "com.herokuapp.receptio.repository")
public class Neo4jConfiguration {
}
