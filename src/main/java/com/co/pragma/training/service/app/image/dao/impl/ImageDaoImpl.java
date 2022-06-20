package com.co.pragma.training.service.app.image.dao.impl;

import com.co.pragma.training.service.app.image.dao.ImageDao;
import com.co.pragma.training.service.app.image.dao.repository.ImageRepository;
import com.co.pragma.training.service.app.image.model.domain.Image;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.adapter.rxjava.RxJava2Adapter;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class ImageDaoImpl implements ImageDao {

  private final ImageRepository imageRepository;

  @Override
  public Completable save(Image image) {
    return Mono.fromCallable(() -> ImageMapper.mapImageEntity(image))
            .flatMap(imageRepository::save)
            .as(RxJava2Adapter::monoToCompletable)
            .subscribeOn(Schedulers.io());
  }

  @Override
  public Observable<Image> getImages() {
    return imageRepository.findAll()
            .as(RxJava2Adapter::fluxToObservable)
            .subscribeOn(Schedulers.io())
            .map(ImageMapper::mapImage);
  }

  @Override
  public Single<Image> getImage(Long idPerson) {
    return imageRepository.findByIdPerson(idPerson)
            .as(RxJava2Adapter::monoToSingle)
            .subscribeOn(Schedulers.io())
            .map(ImageMapper::mapImage);
  }

}
