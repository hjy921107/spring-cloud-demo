package com.jyhuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceConsumerDept8081Ribbon_Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConsumerDept8081Ribbon_Application.class, args);
    }
}
