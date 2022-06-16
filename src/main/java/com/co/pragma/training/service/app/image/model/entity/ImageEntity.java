package com.co.pragma.training.service.app.image.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "IMAGE")
public class ImageEntity {

  @Id
  private String id;
  private Long idPerson;
  private String content;

}