package com.co.pragma.training.service.app.application.usecase.impl;

import com.co.pragma.training.service.app.application.usecase.ImageSearchService;
import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.application.dao.ImageDao;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageSearchServiceImpl implements ImageSearchService {

  private final ImageDao imageDao;

  @Override
  public Single<Image> getImage(Long idPerson) {
    return imageDao.getImage(idPerson);
  }

}
