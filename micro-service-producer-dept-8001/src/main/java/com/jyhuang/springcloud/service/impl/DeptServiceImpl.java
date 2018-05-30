package com.jyhuang.springcloud.service.impl;

import com.jyhuang.springcloud.entity.Dept;
import com.jyhuang.springcloud.mapper.DeptMapper;
import com.jyhuang.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public Long insert(Dept dept) {
        deptMapper.insertDept(dept);

        return dept.getDeptNo();
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }

}
