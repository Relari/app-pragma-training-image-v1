package com.co.pragma.training.service.app.infrastructure.db.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Lazy
@Configuration
@EnableReactiveMongoRepositories(basePackages = {"com.co.pragma.training.service.app.infrastructure.db.repository"})
@EntityScan(basePackages = "com.co.pragma.training.service.app.infrastructure.db.model")
public class DatabaseConfiguration {
}
