package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.application.usecase.ImageSearchAllService;
import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageSearchAllServiceImpl implements ImageSearchAllService {

  private final ImageDao imageDao;

  @Override
  public Observable<Image> getImages() {
    return imageDao.getImages();
  }

}
