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
            .subscribeOn(Schedulers.io())
            .doOnSubscribe(disposable ->
                    log.debug(
                            "Saving the image of the person in the database. [idPerson={}]",
                            image.getIdPerson()
                    )
            )
            .doOnError(throwable ->
                    log.error(
                            "An error occurred while saving the image of the person in the database. [idPerson={}]",
                            image.getIdPerson(), throwable
                    )
            )
            .doOnComplete(() ->
                    log.debug("The image of the person was saved successfully.")
            );
  }

  @Override
  public Observable<Image> getImages() {
    return imageRepository.findAll()
            .as(RxJava2Adapter::fluxToObservable)
            .subscribeOn(Schedulers.io())
            .map(ImageMapper::mapImage)
            .doOnSubscribe(disposable ->
                    log.debug("Searching the images of people in the database.")
            )
            .doOnError(throwable ->
                    log.error(
                            "An error occurred when searching the images of people in the database.",
                            throwable
                    )
            )
            .doOnComplete(() ->
                    log.debug("The images of the people were found correctly.")
            );
  }

  @Override
  public Single<Image> getImage(Long idPerson) {
    return imageRepository.findByIdPerson(idPerson)
            .as(RxJava2Adapter::monoToSingle)
            .subscribeOn(Schedulers.io())
            .map(ImageMapper::mapImage)
            .doOnSubscribe(disposable ->
                    log.debug(
                            "Searching for the image of the person in the database. [idPerson={}]",
                            idPerson
                    )
            )
            .doOnError(throwable ->
                    log.error(
                            "An error occurred when searching the image of the person in the database. [idPerson={}]",
                            idPerson, throwable
                    )
            )
            .doOnSuccess(image ->
                    log.debug("The image of the person was found correctly.")
            );
  }

}
