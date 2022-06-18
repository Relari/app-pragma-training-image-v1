package com.co.pragma.training.service.app.image.util;

import com.co.pragma.training.service.app.image.model.api.ImageRequest;
import com.co.pragma.training.service.app.image.model.domain.Image;
import com.co.pragma.training.service.app.image.model.entity.ImageEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtil {

  private static final Long idPerson  = 1L;
  private static final String content  = "lkjadlkjadflkjasdlkjasdlkjasdlkj";
  private static final String id  = "70a14d5e-bb62-4b8a-9582-b11d765fba4f";

  public static ImageRequest buildImageRequest() {
    return new ImageRequest(idPerson, content);
  }

  public static Image buildImage() {
    return Image.builder()
            .id(id)
            .idPerson(idPerson)
            .content(content)
            .build();
  }

  public static ImageEntity buildImageEntity() {
    return ImageEntity.builder()
            .id(id)
            .idPerson(idPerson)
            .content(content)
            .build();
  }

}
