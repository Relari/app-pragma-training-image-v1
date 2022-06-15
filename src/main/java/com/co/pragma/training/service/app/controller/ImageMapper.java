package com.co.pragma.training.service.app.controller;

import com.co.pragma.training.service.app.image.model.api.ImageRequest;
import com.co.pragma.training.service.app.image.model.api.ImageResponse;
import com.co.pragma.training.service.app.image.model.domain.Image;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageMapper {

  public static Image mapImage(ImageRequest imageRequest) {
    return Image.builder()
            .id(UUID.randomUUID().toString())
            .code(imageRequest.getCode())
            .description(imageRequest.getDescription())
            .uri(imageRequest.getUri())
            .build();
  }

  public static ImageResponse mapImageResponse(Image image) {
    return ImageResponse.builder()
            .id(image.getId())
            .code(image.getCode())
            .description(image.getDescription())
            .uri(image.getUri())
            .build();
  }

}
