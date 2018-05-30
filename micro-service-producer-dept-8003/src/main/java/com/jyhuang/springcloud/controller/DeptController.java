package com.jyhuang.springcloud.controller;

import com.jyhuang.springcloud.entity.Dept;
import com.jyhuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RequestMapping("/producer/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @PostMapping("/insert")
    public Long insert(@RequestBody Dept dept) {
        return deptService.insert(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }
}
