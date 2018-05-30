package com.jyhuang.springcloud.mapper;

import com.jyhuang.springcloud.entity.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Insert("insert into dept(dept_name, db_source) values (#{deptName}, database())")
    Long insertDept(Dept dept);

    @Select("select * from dept where dept_no = #{id}")
    Dept findById(Long id);

    @Select("select * from dept")
    List<Dept> findAll();
}
