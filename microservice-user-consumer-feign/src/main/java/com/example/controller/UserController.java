package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manage/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{string}")
    public String test(@PathVariable String string) {
        System.out.println("-------------------" + string + "-------------------");
        return userService.test(string);
    }

}
