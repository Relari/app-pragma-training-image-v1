package com.co.pragma.training.service.app.infrastructure.config.spring;

import com.co.pragma.training.service.app.application.dao.ImageDao;
import com.co.pragma.training.service.app.application.usecase.ImageCreateService;
import com.co.pragma.training.service.app.application.usecase.ImageSearchAllService;
import com.co.pragma.training.service.app.application.usecase.ImageSearchService;
import com.co.pragma.training.service.app.application.usecase.impl.ImageCreateServiceImpl;
import com.co.pragma.training.service.app.application.usecase.impl.ImageSearchAllServiceImpl;
import com.co.pragma.training.service.app.application.usecase.impl.ImageSearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
public class SpringConfiguration {

    @Bean
    public ImageCreateService personCreateService(
            ImageDao imageDao) {
        return new ImageCreateServiceImpl(imageDao);
    }

    @Bean
    public ImageSearchAllService personSearchOlderAgesService(
            ImageDao imageDao) {
        return new ImageSearchAllServiceImpl(imageDao);
    }

    @Bean
    public ImageSearchService personSearchService(
            ImageDao imageDao) {
        return new ImageSearchServiceImpl(imageDao);
    }

    @Bean
    public HeaderApplication dataMemory() {
        return new HeaderApplication();
    }

}
