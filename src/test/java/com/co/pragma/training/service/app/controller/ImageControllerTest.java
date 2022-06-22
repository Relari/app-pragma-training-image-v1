package com.co.pragma.training.service.app.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
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

    var image = TestUtil.buildImage();

    when(imageService.getImages())
            .thenReturn(Observable.just(image));

    var testObserver = imageController.getImages().test();
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

    when(imageService.getImage(anyLong()))
            .thenReturn(Single.just(image));

    var testObserver = imageController.getImage(image.getIdPerson()).test();
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

    when(imageService.save(any()))
            .thenReturn(Completable.complete());

    var imageRequest = TestUtil.buildImageRequest();

    var testObserver = imageController.saveImage(imageRequest).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();
  }

}
