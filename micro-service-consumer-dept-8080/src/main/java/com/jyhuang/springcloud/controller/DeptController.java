package com.jyhuang.springcloud.controller;

import com.jyhuang.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
// @RequestMapping("/consumer/dept")
public class DeptController {

    public static final String DEPT_REST_URL_PREFIX = "http://localhost:8000/";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/insert")
    public Long insert(Dept dept) {
        return restTemplate.postForObject(DEPT_REST_URL_PREFIX + "/insert", dept, Long.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Long id) {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX + "/get/" + id, Dept.class);
    }

    @GetMapping("/list")
    public List<Dept> findAll() {
        return restTemplate.getForObject(DEPT_REST_URL_PREFIX + "/list", List.class);
    }
}
