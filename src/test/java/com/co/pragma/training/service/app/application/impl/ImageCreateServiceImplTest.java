package com.co.pragma.training.service.app.application.impl;

import com.co.pragma.training.service.app.application.usecase.impl.ImageCreateServiceImpl;
import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.util.TestUtil;
import io.reactivex.Completable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageCreateServiceImplTest {

  @Mock
  private ImageDao imageDao;

  @InjectMocks
  private ImageCreateServiceImpl employeeService;

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {

    when(imageDao.save(any()))
            .thenReturn(Completable.complete());

    var testObserver = employeeService.save(TestUtil.buildImage()).test();
    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();
  }

}
