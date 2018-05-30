package com.jyhuang.springcloud.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptNo;
    private String deptName;
    private String dbSource;

    public Dept(Long deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

}
