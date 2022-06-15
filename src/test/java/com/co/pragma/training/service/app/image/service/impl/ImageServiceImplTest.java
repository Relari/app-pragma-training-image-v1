package com.co.pragma.training.service.app.image.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.co.pragma.training.service.app.image.dao.ImageDao;
import com.co.pragma.training.service.app.image.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class ImageServiceImplTest {

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private ImageServiceImpl employeeService;

  @Test
  void whenGetAllEmployeesThenReturnEmployees() {

    var image = TestUtil.buildEmployee();

    when(imageDao.getImages())
            .thenReturn(Observable.just(image));

    var testObserver = employeeService.getImages().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors()
            .assertValueAt(0, imageResponse ->
                    imageResponse.getId().equals(image.getId())
            )
            .assertValueAt(0, imageResponse ->
                    imageResponse.getCode().equals(image.getCode())
            )
            .assertValueAt(0, imageResponse ->
                    imageResponse.getDescription().equals(image.getDescription())
            )
            .assertValueAt(0, imageResponse ->
                    imageResponse.getUri().equals(image.getUri())
            );
  }

  @Test
  void whenSearchEmployeeThenReturnEmployee() {

    var image = TestUtil.buildEmployee();

    when(imageDao.getImage(anyString()))
            .thenReturn(Single.just(image));

    var testObserver = employeeService.getImage(image.getCode()).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
            .assertValue(imageResponse ->
                    imageResponse.getId().equals(image.getId())
            )
            .assertValue(imageResponse ->
                    imageResponse.getCode().equals(image.getCode())
            )
            .assertValue(imageResponse ->
                    imageResponse.getDescription().equals(image.getDescription())
            )
            .assertValue(imageResponse ->
                    imageResponse.getUri().equals(image.getUri())
            );
  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {

    when(imageDao.save(any()))
            .thenReturn(Completable.complete());

    var testObserver = employeeService.save(TestUtil.buildEmployee()).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();
  }

}
