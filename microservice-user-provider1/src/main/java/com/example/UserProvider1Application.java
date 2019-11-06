package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient // 激活Eureka中的DiscoveryClient实现，实现Controller中对服务信息的输出
public class UserProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider1Application.class, args);
    }

}
