package com.jyhuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 开启 Eureka 服务端
public class MicroServiceEureka8761_Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka8761_Application.class, args);
    }
}
