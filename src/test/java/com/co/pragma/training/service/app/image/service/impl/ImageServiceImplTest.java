package com.co.pragma.training.service.app.image.service.impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
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

    var image = TestUtil.buildImage();

    when(imageDao.getImages())
            .thenReturn(Observable.just(image));

    var testObserver = employeeService.getImages().test();
    testObserver.awaitTerminalEvent();
    testObserver.assertComplete().assertNoErrors()
            .assertValueAt(0, imageResponse ->
                    imageResponse.getId().equals(image.getId())
            )
            .assertValueAt(0, imageResponse ->
                    imageResponse.getIdPerson().equals(image.getIdPerson())
            )
            .assertValueAt(0, imageResponse ->
                    imageResponse.getContent().equals(image.getContent())
            );
  }

  @Test
  void whenSearchEmployeeThenReturnEmployee() {

    var image = TestUtil.buildImage();

    when(imageDao.getImage(anyLong()))
            .thenReturn(Single.just(image));

    var testObserver = employeeService.getImage(image.getIdPerson()).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
            .assertValue(imageResponse ->
                    imageResponse.getId().equals(image.getId())
            )
            .assertValue(imageResponse ->
                    imageResponse.getIdPerson().equals(image.getIdPerson())
            )
            .assertValue(imageResponse ->
                    imageResponse.getContent().equals(image.getContent())
            );
  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {

    when(imageDao.save(any()))
            .thenReturn(Completable.complete());

    var testObserver = employeeService.save(TestUtil.buildImage()).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();
  }

}
