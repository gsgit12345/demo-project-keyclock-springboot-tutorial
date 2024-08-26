package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerApp {

    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String welcomeHello() {
        return "Hello";
    }
}

