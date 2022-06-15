package com.co.pragma.training.service.app.image.model.api;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequest {

  private String code;
  private String description;
  private String uri;

}
