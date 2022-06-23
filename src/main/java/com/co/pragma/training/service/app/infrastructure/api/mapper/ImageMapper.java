package com.co.pragma.training.service.app.infrastructure.api.mapper;

import com.co.pragma.training.service.app.infrastructure.api.model.ImageRequest;
import com.co.pragma.training.service.app.infrastructure.api.model.ImageResponse;
import com.co.pragma.training.service.app.domain.Image;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageMapper {

  public static Image mapImage(ImageRequest imageRequest) {
    return Image.builder()
            .id(UUID.randomUUID().toString())
            .idPerson(imageRequest.getIdPerson())
            .content(imageRequest.getContent())
            .build();
  }

  public static ImageResponse mapImageResponse(Image image) {
    return ImageResponse.builder()
            .id(image.getId())
            .idPerson(image.getIdPerson())
            .content(image.getContent())
            .build();
  }

}
