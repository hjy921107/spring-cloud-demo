package com.jyhuang.springcloud.service;

import com.jyhuang.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    Long insert(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
