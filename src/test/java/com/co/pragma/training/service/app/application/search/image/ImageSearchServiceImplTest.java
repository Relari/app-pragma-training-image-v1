package com.co.pragma.training.service.app.application.search.image;

import com.co.pragma.training.service.app.infrastructure.db.ImageDao;
import com.co.pragma.training.service.app.util.TestUtil;
import io.reactivex.Single;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageSearchServiceImplTest {

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private ImageSearchServiceImpl imageSearchService;

  @Test
  void whenSearchEmployeeThenReturnEmployee() {

    var image = TestUtil.buildImage();

    when(imageDao.getImage(anyLong()))
            .thenReturn(Single.just(image));

    var testObserver = imageSearchService.getImage(image.getIdPerson()).test();
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

}
