package com.example.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloControllerApp {

    private final RestTemplate  template=new RestTemplateBuilder().build();
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.OK)
    public String welcomeHello() {
        //we are going to get the bearer token from  this microservice
        //and will pass the same token to calling the microservice2.
     Jwt jwt=(Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HttpHeaders  httpHeaders=new HttpHeaders();
        httpHeaders.add("Authorization","Bearer "+jwt.getTokenValue());
        //now call the microservice 2
        template.exchange("Http://localhost:8083/sayhello", HttpMethod.GET,new HttpEntity<>(httpHeaders),String.class);
        return "Hello";
    }
}

