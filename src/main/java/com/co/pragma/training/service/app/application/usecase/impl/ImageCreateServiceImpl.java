package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.application.usecase.ImageCreateService;
import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Completable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageCreateServiceImpl implements ImageCreateService {

  private final ImageDao imageDao;

  @Override
  public Completable save(Image image) {
    return imageDao.save(image);
  }
}
