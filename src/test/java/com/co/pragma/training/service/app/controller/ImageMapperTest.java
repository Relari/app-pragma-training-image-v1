package com.co.pragma.training.service.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;


import com.co.pragma.training.service.app.image.util.TestUtil;
import org.junit.jupiter.api.Test;


class ImageMapperTest {

  @Test
  void testMapEmployee() {

    var imageRequest = TestUtil.buildEmployeeRequest();
    var image = ImageMapper.mapImage(imageRequest);

    assertEquals(imageRequest.getCode(), image.getCode());
    assertEquals(imageRequest.getDescription(), image.getDescription());
    assertEquals(imageRequest.getUri(), image.getUri());

  }

  @Test
  void testMapEmployeeResponse() {

    var image = TestUtil.buildEmployee();
    var imageResponse = ImageMapper.mapImageResponse(image);

    assertEquals(image.getId(), imageResponse.getId());
    assertEquals(image.getCode(), imageResponse.getCode());
    assertEquals(image.getDescription(), imageResponse.getDescription());
    assertEquals(image.getUri(), imageResponse.getUri());

  }
}
