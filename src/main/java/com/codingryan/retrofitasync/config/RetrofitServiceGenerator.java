package com.codingryan.retrofitasync.config;

import com.codingryan.retrofitasync.domain.service.TestApiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

@Configuration
public class RetrofitServiceGenerator {

    @Bean
    public TestApiService testApiService(Retrofit retrofit) {
        return retrofit.create(TestApiService.class);
    }
}
