package com.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${provider.url}")
    private String providerUrl;

    @HystrixCommand(fallbackMethod = "testServiceFallback")
    public String testService(String string) {
        return restTemplate.getForObject(providerUrl + string, String.class);
    }

    public String testServiceFallback(String string) {
        return string + "，出错了！";
    }

}
