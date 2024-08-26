package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeControllerRest {

    @GetMapping("/welcome")

    public  String sayHello()
    {
        return "hello";
    }
}
