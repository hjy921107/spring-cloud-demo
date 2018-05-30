package com.jyhuang.springcloud.controller;

import com.jyhuang.springcloud.entity.Dept;
import com.jyhuang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    // 一旦调用服务方法失败并抛出异常后，会自动调用 @HystrixCommand 中 fallbackMethod 属性指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_get")
    public Dept get(@PathVariable Long id) {
        Dept dept = deptService.get(id);

        if (null == dept) {
            throw new RuntimeException("当前 id = " + id + "在数据库中没有对应的部门信息！");
        }
        return dept;
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    // 回退方法，与原方法可以有相同的参数和返回值类型，可以有异常信息的参数，访问修饰符无所谓
    private Dept processHystrix_get(Long id, Throwable throwable) {
        System.out.println(throwable.getMessage());
        return new Dept(id, "@HystrixCommand: 数据库中没有当前 id = " + id + "对应的部门信息！");
    }
}
