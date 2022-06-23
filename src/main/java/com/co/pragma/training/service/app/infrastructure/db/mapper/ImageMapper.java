package com.co.pragma.training.service.app.infrastructure.db.mapper;

import com.co.pragma.training.service.app.domain.Image;
import com.co.pragma.training.service.app.infrastructure.db.model.ImageEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ImageMapper {

    public static Image mapImage(ImageEntity imageEntity) {
        return Image.builder()
                .id(imageEntity.getId())
                .idPerson(imageEntity.getIdPerson())
                .content(imageEntity.getContent())
                .build();
    }

    public static ImageEntity mapImageEntity(Image image) {
        return ImageEntity.builder()
                .id(image.getId())
                .idPerson(image.getIdPerson())
                .content(image.getContent())
                .build();
    }
}
