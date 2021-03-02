package com.masterli.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Creqated by Limingxuan on 2021/2/28
 */
//部门表
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    private Integer deptId;
    private String deptName;
}
