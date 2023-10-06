package com.sulbasoft.emr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>A Simple Electronic Medical Record - API</h2>");
        stringBuilder.append("<h2>Access the API at localhost:8080/api/v1/patients</h2>");
        
        return stringBuilder.toString();
    }
}
