package com.example.controller;

import com.example.service.AlbumService;
import com.example.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static com.example.utils.JsonResult.jsonResultSuccess;

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



    @Autowired
    private AlbumService albumService;

    @GetMapping("find/{id}")
    JsonResult findById(@PathVariable Long id) {
        return jsonResultSuccess("Success", albumService.findById(id));
    }


}
