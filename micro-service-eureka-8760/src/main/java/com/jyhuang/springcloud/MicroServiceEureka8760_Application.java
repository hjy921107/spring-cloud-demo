package com.jyhuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceEureka8760_Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEureka8760_Application.class, args);
    }
}
