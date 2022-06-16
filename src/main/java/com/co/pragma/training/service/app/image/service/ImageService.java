package com.co.pragma.training.service.app.image.service;

import com.co.pragma.training.service.app.image.model.domain.Image;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ImageService {

  Observable<Image> getImages();

  Single<Image> getImage(Long code);

  Completable save(Image image);
}
