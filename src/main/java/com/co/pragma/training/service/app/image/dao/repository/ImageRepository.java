package com.co.pragma.training.service.app.image.dao.repository;

import com.co.pragma.training.service.app.image.model.entity.ImageEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ImageRepository extends ReactiveMongoRepository<ImageEntity, String> {

  Mono<ImageEntity> findByIdPerson(Long id);
}
