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
  private ImageDaoImpl employeeDao;

  @Test
  void whenGetAllEmployeesThenReturnEmployees() {

    var imageEntity = TestUtil.buildImageEntity();

    when(imageRepository.findAll())
            .thenReturn(Flux.just(imageEntity));

    var testObserver = employeeDao.getImages().test();
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
  void whenSearchEmployeeThenReturnEmployee() {

    var imageEntity = TestUtil.buildImageEntity();

    when(imageRepository.findByIdPerson(anyLong()))
            .thenReturn(Mono.just(imageEntity));

    var testObserver = employeeDao.getImage(imageEntity.getIdPerson()).test();
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
  void whenSaveEmployeeThenReturnSuccessful() {

    when(imageRepository.save(any()))
            .thenReturn(Mono.just(TestUtil.buildImageEntity()));

    var testObserver = employeeDao.save(TestUtil.buildImage()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
  }


}
