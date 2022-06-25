package com.co.pragma.training.service.app.application.usecase;

import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Completable;

public interface ImageCreateService {

  Completable save(Image image);

}
