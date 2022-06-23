package com.co.pragma.training.service.app.application.create;

import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Completable;

public interface ImageCreateService {

  Completable save(Image image);

}
