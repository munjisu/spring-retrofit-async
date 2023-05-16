package com.codingryan.retrofitasync.domain.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public void callback() {
        System.out.println("callback success.");
    }
}
