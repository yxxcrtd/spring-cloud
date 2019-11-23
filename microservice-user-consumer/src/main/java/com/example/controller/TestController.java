package com.example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("manage/test")
public class TestController {

    private Logger logger = LogManager.getLogger(TestController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String providerUrl;

    @GetMapping("{id}")
    public Object add(HttpServletRequest request, @PathVariable Long id) {
        logger.info("这是 Consumer 的输出 abc 123 ......");
        return restTemplate.getForObject(providerUrl + id, Object.class);
    }

}
