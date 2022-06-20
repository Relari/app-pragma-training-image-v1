package com.co.pragma.training.service.app.image.dao;

import com.co.pragma.training.service.app.image.model.domain.Image;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ImageDao {

  Completable save(Image image);

  Observable<Image> getImages();

  Single<Image> getImage(Long idPerson);
}
