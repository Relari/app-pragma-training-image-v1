package com.co.pragma.training.service.app.image.dao.impl;

import com.co.pragma.training.service.app.image.util.TestUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ImageMapperTest {

  @Test
  void testMapEmployee() {

    var imageEntity = TestUtil.buildEmployeeEntity();
    var image = ImageMapper.mapImage(imageEntity);

    assertEquals(imageEntity.getId(), image.getId());
    assertEquals(imageEntity.getCode(), image.getCode());
    assertEquals(imageEntity.getDescription(), image.getDescription());
    assertEquals(imageEntity.getUri(), image.getUri());

  }

  @Test
  void testMapEmployeeEntity() {

    var image = TestUtil.buildEmployee();
    var imageEntity = ImageMapper.mapImageEntity(image);

    assertEquals(image.getId(), imageEntity.getId());
    assertEquals(image.getCode(), imageEntity.getCode());
    assertEquals(image.getDescription(), imageEntity.getDescription());
    assertEquals(image.getUri(), imageEntity.getUri());

  }

}
