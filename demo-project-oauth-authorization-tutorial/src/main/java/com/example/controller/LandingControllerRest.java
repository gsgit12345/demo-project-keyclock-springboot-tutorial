package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingControllerRest {
    @GetMapping("/home")
    public String welcome() {
        return "welcome";
    }

}
