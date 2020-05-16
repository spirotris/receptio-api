package com.herokuapp.receptio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.annotation.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableNeo4jRepositories("com.herokuapp.receptio.repository")
@EnableTransactionManagement
@EnableNeo4jAuditing
public class Neo4jConfiguration {
}
