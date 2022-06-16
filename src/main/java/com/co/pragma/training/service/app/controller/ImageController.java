package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.image.model.api.ImageRequest;
import com.co.pragma.training.service.app.image.model.api.ImageResponse;
import com.co.pragma.training.service.app.image.service.ImageService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${application.api.path}")
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
          @PathVariable("code") Long code) {
    return imageService.getImage(code)
            .map(ImageMapper::mapImageResponse);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Completable saveImage(
          @RequestBody ImageRequest imageRequest) {

    return Single.fromCallable(() -> ImageMapper.mapImage(imageRequest))
            .flatMapCompletable(imageService::save);
  }

}
