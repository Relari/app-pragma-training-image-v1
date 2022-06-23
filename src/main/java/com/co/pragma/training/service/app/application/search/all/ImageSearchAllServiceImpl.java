package com.co.pragma.training.service.app.application.search.all;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.infrastructure.db.ImageDao;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageSearchAllServiceImpl implements ImageSearchAllService {

  private final ImageDao imageDao;

  @Override
  public Observable<Image> getImages() {
    return imageDao.getImages();
  }

}
