package com.jyhuang.springcloud.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    /**
     * 使用 HystrixDashBoard 监控的条件
     * 1. mvn 依赖：spring-cloud-starter-netflix-hystrix，spring-boot-starter-actuator
     * 2. 启动类添加 @EnableCircuitBreaker
     * 3. 注册此 HystrixMetricsStreamServlet
     *          name: HystrixMetricsStreamServlet
     *          urlMapping: /hystrix.stream
     *          @see HystrixMetricsStreamServlet
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet);

        registrationBean.setName("HystrixMetricsStreamServlet");
        registrationBean.addUrlMappings("/hystrix.stream");

        return registrationBean;
    }
}
