package com.co.pragma.training.service.app.application.search.image;

import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Single;

public interface ImageSearchService {

  Single<Image> getImage(Long idPerson);

}
