package com.co.pragma.training.service.app.infrastructure.proxy.config;

import com.co.pragma.training.service.app.infrastructure.proxy.api.JwtTokenApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Lazy
@Configuration
public class RestConfiguration {

  private static final String DEBUG = "DEBUG";
  private static final String TRACE = "TRACE";

  @Value("${application.http-client.jwt-token.base-url}")
  private String jwtTokenUri;

  @Value("${logging.level.com.co.pragma.training.service.app}")
  private String levelLogApp;

  private Retrofit retrofit(String uri) {

    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    validateLoggingLevel(logging);

    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    httpClient.addInterceptor(logging);

    return new Retrofit.Builder()
        .baseUrl(uri)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build();
  }

  private void validateLoggingLevel(HttpLoggingInterceptor logging) {
    switch (levelLogApp) {
      case DEBUG:
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        break;
      case TRACE:
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        break;
      default:
        logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        break;
    }
  }

  @Bean
  public JwtTokenApi jwtTokenApi() {
    return retrofit(jwtTokenUri).create(JwtTokenApi.class);
  }

}
