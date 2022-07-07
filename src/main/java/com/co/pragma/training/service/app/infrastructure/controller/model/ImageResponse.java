package com.co.pragma.training.service.app.infrastructure.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class ImageResponse {

  @Schema(
          description = "Identificador de la imagen",
          implementation = String.class,
          example = "1"
  )
  private String id;

  @Schema(
          description = "Identificador de la persona",
          implementation = Long.class,
          example = "1"
  )
  private Long idPerson;

  @Schema(
          description = "Contenido de la imagen",
          implementation = String.class,
          example = "asdasdasdasgasfgsfdsafdsfsdfsdfsdf"
  )
  private String content;

}
