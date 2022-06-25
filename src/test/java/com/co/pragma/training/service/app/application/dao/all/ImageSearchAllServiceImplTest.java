package com.co.pragma.training.service.app.application.dao.all;

import com.co.pragma.training.service.app.application.usecase.impl.ImageSearchAllServiceImpl;
import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.util.TestUtil;
import io.reactivex.Observable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageSearchAllServiceImplTest {

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private ImageSearchAllServiceImpl imageSearchAllService;

  @Test
  void whenGetAllEmployeesThenReturnEmployees() {

    var image = TestUtil.buildImage();

    when(imageDao.getImages())
            .thenReturn(Observable.just(image));

    var testObserver = imageSearchAllService.getImages().test();
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

}
