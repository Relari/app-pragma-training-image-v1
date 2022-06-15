package com.co.pragma.training.service.app.image.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Image {

  private String id;
  private String code;
  private String description;
  private String uri;

}
