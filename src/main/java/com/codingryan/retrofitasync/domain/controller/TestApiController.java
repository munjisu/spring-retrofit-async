package com.codingryan.retrofitasync.domain.controller;

import com.codingryan.retrofitasync.domain.service.TestApiService;
import com.codingryan.retrofitasync.domain.service.TestService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tests")
public class TestApiController {

    private final TestApiService testApiService;
    private final TestService testService;

    @GetMapping("/1")
    public ResponseEntity<String> requestTest(@RequestParam Long delaySeconds) {
        Call<Void> call = testApiService.getTest1(delaySeconds);
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(@NotNull Call<Void> call, @NotNull Response<Void> response) {
                testService.callback();
            }

            @Override
            public void onFailure(@NotNull Call<Void> call, @NotNull Throwable t) {
                System.out.println("error.");
            }
        });

        return ResponseEntity.ok().build();
    }

    @GetMapping("/callback")
    public ResponseEntity<String> callback(@RequestParam Long delaySeconds) throws InterruptedException {
        Thread.sleep(delaySeconds * 1000);
        return ResponseEntity.ok().build();
    }
}
