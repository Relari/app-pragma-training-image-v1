package com.co.pragma.training.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ImageApplication {

  public static void main(String[] args) {
    SpringApplication.run(ImageApplication.class);
  }

}
