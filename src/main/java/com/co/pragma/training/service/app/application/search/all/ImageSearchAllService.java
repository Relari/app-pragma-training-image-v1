package com.co.pragma.training.service.app.application.search.all;

import com.co.pragma.training.service.app.domain.Image;
import io.reactivex.Observable;

public interface ImageSearchAllService {

  Observable<Image> getImages();

}
