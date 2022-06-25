package com.co.pragma.training.service.app.infrastructure.api.controller;

import com.co.pragma.training.service.app.application.usecase.ImageSearchAllService;
import com.co.pragma.training.service.app.application.usecase.ImageSearchService;
import com.co.pragma.training.service.app.infrastructure.api.model.ImageRequest;
import com.co.pragma.training.service.app.infrastructure.api.model.ImageResponse;
import com.co.pragma.training.service.app.application.usecase.ImageCreateService;
import com.co.pragma.training.service.app.infrastructure.api.mapper.ImageMapper;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Image", description = "Image Controller")
@OpenAPIDefinition(
        info = @Info(
                title = "Image API",
                version = "${application.info.version}",
                description = "${application.info.description}"
        )
)

@RestController
@RequestMapping(path = "${application.api.path}")
@AllArgsConstructor
public class ImageController {

  private final ImageCreateService imageCreateService;
  private final ImageSearchService imageSearchService;
  private final ImageSearchAllService imageSearchAllService;

  @Operation(
          summary = "Obtiene la informacion de un estudiante.",
          method = "GET",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Show Students",
                          content = @Content(
                                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                                  array = @ArraySchema(
                                          schema = @Schema(implementation = ImageResponse.class)
                                  )
                          )
                  )
          })
  @GetMapping
  public Observable<ImageResponse> getImages() {
    return imageSearchAllService.getImages()
            .map(ImageMapper::mapImageResponse);
  }

  @Operation(
          summary = "Obtiene la informacion de un estudiante.",
          method = "GET",
          responses = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Show Students",
                          content = @Content(
                                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                                  schema = @Schema(implementation = ImageResponse.class)
                          )
                  )
          })
  @GetMapping(path = "/{idPerson}")
  public Single<ImageResponse> getImage(
          @Parameter(
                  description = "Identificaci&oacute;n",
                  in = ParameterIn.QUERY,
                  schema = @Schema(
                          implementation = Long.class
                  ),
                  example = "1",
                  required = true
          )
          @PathVariable("idPerson") Long idPerson) {
    return imageSearchService.getImage(idPerson)
            .map(ImageMapper::mapImageResponse);
  }

  @Operation(
          summary = "Guarda al empleado",
          method = "POST",
          responses = {
                  @ApiResponse(
                          responseCode = "201",
                          description = "Create Successful"
                  ),
                  @ApiResponse(
                          responseCode = "500",
                          description = "Error to Save",
                          content = @Content(
                                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                                  schema = @Schema(implementation = Throwable.class)
                          )
                  )
          })
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Completable saveImage(
          @RequestBody ImageRequest imageRequest) {

    return Single.fromCallable(() -> ImageMapper.mapImage(imageRequest))
            .flatMapCompletable(imageCreateService::save);
  }

}
