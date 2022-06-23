package com.co.pragma.training.service.app.infrastructure.db;

import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface ImageDao {

  Completable save(Image image);

  Observable<Image> getImages();

  Single<Image> getImage(Long idPerson);
}
