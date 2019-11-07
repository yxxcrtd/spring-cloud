package com.example.controller;

import com.example.service.AlbumService;
import com.example.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.utils.JsonResult.jsonResultSuccess;

@RestController
@RequestMapping("api/user")
public class UserApi {

    @Autowired
    private AlbumService albumService;

    @GetMapping("{id}")
    JsonResult findById(@PathVariable Long id) {
        return jsonResultSuccess("Provider 0 ->", albumService.findById(id));
    }

}
