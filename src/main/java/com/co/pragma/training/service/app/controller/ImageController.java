package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.image.model.api.ImageRequest;
import com.co.pragma.training.service.app.image.model.api.ImageResponse;
import com.co.pragma.training.service.app.image.service.ImageService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ImageController {

  private final ImageService imageService;

  @GetMapping
  public Observable<ImageResponse> getImages() {
    return imageService.getImages()
            .map(ImageMapper::mapImageResponse);
  }

  @GetMapping(path = "/{code}")
  public Single<ImageResponse> getImage(
          @PathVariable("code") String code) {
    return imageService.getImage(code)
            .map(ImageMapper::mapImageResponse);
  }

  @PostMapping
  public Completable saveImage(
          ImageRequest imageRequest) {
    return Single.fromCallable(() -> ImageMapper.mapImage(imageRequest))
            .flatMapCompletable(imageService::save);
  }

}
