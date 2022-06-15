package com.co.pragma.training.service.app.image.dao.impl;

import com.co.pragma.training.service.app.image.dao.repository.ImageRepository;
import com.co.pragma.training.service.app.image.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageDaoImplTest {

  @Mock
  private ImageRepository imageRepository;

  @InjectMocks
  private ImageDaoImpl employeeDao;

  @Test
  void whenGetAllEmployeesThenReturnEmployees() {

    var imageEntity = TestUtil.buildEmployeeEntity();

    when(imageRepository.findAll())
            .thenReturn(Flux.just(imageEntity));

    var testObserver = employeeDao.getImages().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors()
            .assertValueAt(0, image ->
                    image.getId().equals(imageEntity.getId())
            )
            .assertValueAt(0, image ->
                    image.getCode().equals(imageEntity.getCode())
            )
            .assertValueAt(0, image ->
                    image.getDescription().equals(imageEntity.getDescription())
            )
            .assertValueAt(0, image ->
                    image.getUri().equals(imageEntity.getUri())
            );
  }

  @Test
  void whenSearchEmployeeThenReturnEmployee() {

    var imageEntity = TestUtil.buildEmployeeEntity();

    when(imageRepository.findById(anyString()))
            .thenReturn(Mono.just(imageEntity));

    var testObserver = employeeDao.getImage(imageEntity.getCode()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors()
            .assertValue(image ->
                    image.getId().equals(imageEntity.getId())
            )
            .assertValue(image ->
                    image.getCode().equals(imageEntity.getCode())
            )
            .assertValue(image ->
                    image.getDescription().equals(imageEntity.getDescription())
            )
            .assertValue(image ->
                    image.getUri().equals(imageEntity.getUri())
            );
  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {

    when(imageRepository.save(any()))
            .thenReturn(Mono.just(TestUtil.buildEmployeeEntity()));

    var testObserver = employeeDao.save(TestUtil.buildEmployee()).test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors();
  }


}
