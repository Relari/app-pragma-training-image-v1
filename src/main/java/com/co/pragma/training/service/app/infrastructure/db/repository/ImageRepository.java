package com.co.pragma.training.service.app.infrastructure.db.repository;

import com.co.pragma.training.service.app.infrastructure.db.model.ImageEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ImageRepository extends ReactiveMongoRepository<ImageEntity, String> {

  Mono<ImageEntity> findByIdPerson(Long id);
}
