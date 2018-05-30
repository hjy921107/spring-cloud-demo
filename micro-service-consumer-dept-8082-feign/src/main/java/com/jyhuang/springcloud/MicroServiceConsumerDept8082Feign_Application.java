package com.jyhuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MicroServiceConsumerDept8082Feign_Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConsumerDept8082Feign_Application.class, args);
    }
}
