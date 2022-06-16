package com.co.pragma.training.service.app.image.service.impl;

import com.co.pragma.training.service.app.image.model.domain.Image;
import com.co.pragma.training.service.app.image.service.ImageService;
import com.co.pragma.training.service.app.image.dao.ImageDao;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {

  private final ImageDao imageDao;

  @Override
  public Observable<Image> getImages() {
    return imageDao.getImages();
  }

  @Override
  public Single<Image> getImage(Long code) {
    return imageDao.getImage(code);
  }

  @Override
  public Completable save(Image image) {
    return imageDao.save(image);
  }
}
