package com.codingryan.retrofitasync.domain.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestApiService {

    @GET("/api/tests/callback")
    Call<Void> getTest1(@Query("delaySeconds") Long delaySeconds);
}
