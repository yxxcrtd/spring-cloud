package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("manage/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String providerUrl;

    @GetMapping("{string}")
    public String add(@PathVariable String string) {
        return restTemplate.getForObject(providerUrl + string, String.class);
    }



}