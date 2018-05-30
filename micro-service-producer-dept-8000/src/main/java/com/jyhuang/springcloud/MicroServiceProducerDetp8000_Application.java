package com.jyhuang.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.jyhuang.springcloud.mapper")
@EnableEurekaClient // 开启 Eureka 客户端
public class MicroServiceProducerDetp8000_Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceProducerDetp8000_Application.class, args);
    }
}
