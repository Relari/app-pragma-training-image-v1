package com.co.pragma.training.service.app.infrastructure.controller.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ImageRequest {

  @Schema(
          description = "Identificador de la persona",
          implementation = Long.class,
          example = "1",
          required = true
  )
  @NotNull
  private Long idPerson;

  @Schema(
          description = "Contenido de la imagen",
          implementation = String.class,
          example = "asdasdasdasgasfgsfdsafdsfsdfsdfsdf",
          required = true
  )
  @NotBlank
  private String content;

}
