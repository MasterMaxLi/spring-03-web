package com.masterli.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Creqated by Limingxuan on 2021/2/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer gender;

    private Department department;
    private Date birthday;
}
