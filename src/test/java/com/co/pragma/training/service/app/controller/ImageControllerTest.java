package com.co.pragma.training.service.app.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import com.co.pragma.training.service.app.image.service.ImageService;
import com.co.pragma.training.service.app.image.util.TestUtil;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ImageControllerTest {

  @Mock
  private ImageService imageService;

  @InjectMocks
  private ImageController imageController;

  @Test
  void whenGetAllEmployeesThenReturnEmployees() {

    var image = TestUtil.buildEmployee();

    when(imageService.getImages())
            .thenReturn(Observable.just(image));

    var testObserver = imageController.getImages().test();
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

    var employee = TestUtil.buildEmployee();

    when(imageService.getImage(anyString()))
            .thenReturn(Single.just(employee));

    var testObserver = imageController.getImage(employee.getCode()).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
            .assertValue(imageResponse ->
                    imageResponse.getId().equals(employee.getId())
            )
            .assertValue(imageResponse ->
                    imageResponse.getCode().equals(employee.getCode())
            )
            .assertValue(imageResponse ->
                    imageResponse.getDescription().equals(employee.getDescription())
            )
            .assertValue(imageResponse ->
                    imageResponse.getUri().equals(employee.getUri())
            );
  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {

    when(imageService.save(any()))
            .thenReturn(Completable.complete());

    var imageRequest = TestUtil.buildEmployeeRequest();

    var testObserver = imageController.saveImage(imageRequest).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();
  }

}
