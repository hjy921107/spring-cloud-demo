package com.jyhuang.springcloud.service;

import com.jyhuang.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 使用 Feign 进行面向接口编程时，有以下注意点：
 *
 * 1. @PathVariable 建议指定注解的 value 属性值，不指定有时会报错
 * 2. 建议使用 @FeignClient 的 fallbackFactory 属性进行服务降级处理
 *      使用 fallback 指定的回退类，因为需要实现请求接口，如此处的 DeptClientService，
 *      如果此接口上使用了 @RequestMapping 注解，运行会出现无法映射的问题，
 *      将类上的 @RequestMapping 属性值整合到方法上的 @GetMapping 中可正常执行
 *      所以不建议使用
 * 3. 网上还说在 Feign 接口中不要使用具体的 @XXXMapping 注解，使用 @RequestMapping，
 *      目前使用下面的 @GetMapping 未遇到问题
 */

@FeignClient(value = "MICRO-SERVICE-PRODUCER-DEPT",
             // fallback = DeptClientService.HystrixFallback.class
             fallbackFactory = DeptClientService.HystrixFallbackFactory.class
)
// @RequestMapping("/producer/dept")
public interface DeptClientService {

    @GetMapping("/insert")
    Long insert(Dept dept);

    @GetMapping("/get/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/list")
    List<Dept> findAll();

    // 服务降级
    /*
        方法一：fallback 属性指定回退类，实现 DeptClientService

        @Component
        class HystrixFallback implements DeptClientService {
            @Override
            public Long insert(Dept dept) {
                return null;
            }

            @Override
            public Dept get(Long id) {
                return new Dept(id, "fallback");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }
        }
     */

    // 方法二：fallbackFactory 属性指定回退工厂类，实现 FallbackFactory，类型为 DeptClientService
    @Component
    class HystrixFallbackFactory implements FallbackFactory<DeptClientService> {
        @Override
        public DeptClientService create(Throwable cause) {
            return new DeptClientService() {
                @Override
                public Long insert(Dept dept) {
                    return null;
                }

                @Override
                public Dept get(Long id) {
                    return new Dept(id, "fallbackFactory");
                }

                @Override
                public List<Dept> findAll() {
                    return null;
                }
            };
        }
    }
}
