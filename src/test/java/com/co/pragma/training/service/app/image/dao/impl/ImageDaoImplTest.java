package com.co.pragma.training.service.app.image.dao.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.co.pragma.training.service.app.image.dao.repository.ImageRepository;
import com.co.pragma.training.service.app.image.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
class ImageDaoImplTest {

  @Mock
  private ImageRepository imageRepository;

  @InjectMocks
  private ImageDaoImpl imageDao;

  @Test
  void whenGetAllImagesThenReturnImages() {

    var imageEntity = TestUtil.buildImageEntity();

    when(imageRepository.findAll())
            .thenReturn(Flux.just(imageEntity));

    var testObserver = imageDao.getImages().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors()
            .assertValueAt(0, image ->
                    image.getId().equals(imageEntity.getId())
            )
            .assertValueAt(0, image ->
                    image.getIdPerson().equals(imageEntity.getIdPerson())
            )
            .assertValueAt(0, image ->
                    image.getContent().equals(imageEntity.getContent())
            );
  }

  @Test
  void whenGetAllImagesThenReturnError() {

    var imageEntity = TestUtil.buildImageEntity();

    when(imageRepository.findAll())
            .thenReturn(Flux.error(new Throwable()));

    var testObserver = imageDao.getImages().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertNotComplete().assertError(Throwable.class);
  }

  @Test
  void whenSearchImageThenReturnImage() {

    var imageEntity = TestUtil.buildImageEntity();

    when(imageRepository.findByIdPerson(anyLong()))
            .thenReturn(Mono.just(imageEntity));

    var testObserver = imageDao.getImage(imageEntity.getIdPerson()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors()
            .assertValue(image ->
                    image.getId().equals(imageEntity.getId())
            )
            .assertValue(image ->
                    image.getIdPerson().equals(imageEntity.getIdPerson())
            )
            .assertValue(image ->
                    image.getContent().equals(imageEntity.getContent())
            );
  }

  @Test
  void whenSearchImageThenReturnError() {

    var imageEntity = TestUtil.buildImageEntity();

    when(imageRepository.findByIdPerson(anyLong()))
            .thenReturn(Mono.error(new Throwable()));

    var testObserver = imageDao.getImage(imageEntity.getIdPerson()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertNotComplete().assertError(Throwable.class);
  }

  @Test
  void whenSaveImageThenReturnSuccessful() {

    when(imageRepository.save(any()))
            .thenReturn(Mono.just(TestUtil.buildImageEntity()));

    var testObserver = imageDao.save(TestUtil.buildImage()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
  }

  @Test
  void whenSaveImageThenReturnError() {

    when(imageRepository.save(any()))
            .thenReturn(Mono.error(new Throwable()));

    var testObserver = imageDao.save(TestUtil.buildImage()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertNotComplete().assertError(Throwable.class);
  }
}
