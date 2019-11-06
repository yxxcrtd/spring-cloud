package com.example.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("microservice-user-provider")
public interface UserService {

    @GetMapping("{string}")
    String test(@PathVariable String string);

}
