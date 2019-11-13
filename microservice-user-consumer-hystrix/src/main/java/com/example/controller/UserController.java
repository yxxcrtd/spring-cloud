package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${provider.url}")
    private String providerUrl;

    @GetMapping("{string}")
    public String add(@PathVariable String string) {
        return userService.testService(string);
    }

}
