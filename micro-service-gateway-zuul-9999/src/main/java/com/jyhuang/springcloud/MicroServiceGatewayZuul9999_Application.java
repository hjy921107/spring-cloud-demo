package com.jyhuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroServiceGatewayZuul9999_Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceGatewayZuul9999_Application.class, args);
    }
}

