package com.co.pragma.training.service.app.infrastructure.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.co.pragma.training.service.app.util.TestUtil;
import org.junit.jupiter.api.Test;


class ImageMapperTest {

  @Test
  void testMapEmployee() {

    var imageRequest = TestUtil.buildImageRequest();
    var image = ImageMapper.mapImage(imageRequest);

    assertEquals(imageRequest.getIdPerson(), image.getIdPerson());
    assertEquals(imageRequest.getContent(), image.getContent());

  }

  @Test
  void testMapEmployeeResponse() {

    var image = TestUtil.buildImage();
    var imageResponse = ImageMapper.mapImageResponse(image);

    assertEquals(image.getId(), imageResponse.getId());
    assertEquals(image.getIdPerson(), imageResponse.getIdPerson());
    assertEquals(image.getContent(), imageResponse.getContent());

  }
}
