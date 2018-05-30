package com.jyhuang.springcloud.controller;

import com.jyhuang.springcloud.entity.Dept;
import com.jyhuang.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// @RequestMapping("/consumer/dept")
public class DeptController {

    /*
        public static final String DEPT_REST_URL_PREFIX = "http://MICRO-SERVICE-PRODUCER-DEPT"; // 从 Eureka Server 获取服务

        @Autowired
        private RestTemplate restTemplate;
    */

    // 使用 Feign，面向接口编程
    @Autowired
    private DeptClientService deptClientService;

    @GetMapping("/insert")
    public Long insert(Dept dept) {
        return deptClientService.insert(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptClientService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> findAll() {
        return deptClientService.findAll();
    }
}
