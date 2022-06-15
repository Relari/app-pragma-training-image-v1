package com.co.pragma.training.service.app.image.util;

import com.co.pragma.training.service.app.image.model.api.ImageRequest;
import com.co.pragma.training.service.app.image.model.domain.Image;
import com.co.pragma.training.service.app.image.model.entity.ImageEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestUtil {

  private static final String code  = "code";
  private static final String description  = "description";
  private static final String uri  = "uri";
  private static final String id  = "70a14d5e-bb62-4b8a-9582-b11d765fba4f";

  public static ImageRequest buildEmployeeRequest() {
    return ImageRequest.builder()
            .code(code)
            .uri(uri)
            .description(description)
            .build();
  }

  public static Image buildEmployee() {
    return Image.builder()
            .id(id)
            .code(code)
            .uri(uri)
            .description(description)
            .build();
  }

  public static ImageEntity buildEmployeeEntity() {
    return ImageEntity.builder()
            .id(id)
            .code(code)
            .uri(uri)
            .description(description)
            .build();
  }

}
