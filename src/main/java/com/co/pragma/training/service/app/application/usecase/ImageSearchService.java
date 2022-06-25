package com.co.pragma.training.service.app.application.usecase;

import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Single;

public interface ImageSearchService {

  Single<Image> getImage(Long idPerson);

}
