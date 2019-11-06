package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserApi {

    @GetMapping("{string}")
    public String test(@PathVariable String string) {
        return "Provider 0 -> Hello " + string;
    }

}
