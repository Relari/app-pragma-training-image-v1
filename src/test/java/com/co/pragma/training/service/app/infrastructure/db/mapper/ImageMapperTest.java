package com.co.pragma.training.service.app.infrastructure.db.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.co.pragma.training.service.app.util.TestUtil;
import org.junit.jupiter.api.Test;

class ImageMapperTest {

  @Test
  void testMapEmployee() {

    var imageEntity = TestUtil.buildImageEntity();
    var image = ImageMapper.mapImage(imageEntity);

    assertEquals(imageEntity.getId(), image.getId());
    assertEquals(imageEntity.getIdPerson(), image.getIdPerson());
    assertEquals(imageEntity.getContent(), image.getContent());

  }

  @Test
  void testMapEmployeeEntity() {

    var image = TestUtil.buildImage();
    var imageEntity = ImageMapper.mapImageEntity(image);

    assertEquals(image.getId(), imageEntity.getId());
    assertEquals(image.getIdPerson(), imageEntity.getIdPerson());
    assertEquals(image.getContent(), imageEntity.getContent());

  }

}
