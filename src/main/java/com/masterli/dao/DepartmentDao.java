package com.masterli.dao;

import com.masterli.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Creqated by Limingxuan on 2021/2/28
 */
//部门dao
@Repository
public class DepartmentDao {

    //模拟数据库中的数据

    private static Map<Integer, Department> departments = null;

    static{
        departments = new HashMap<Integer, Department>();

        departments.put(1, new Department(1, "技术部"));
        departments.put(2, new Department(2, "研发部"));
        departments.put(3, new Department(3, "售后部"));
        departments.put(4, new Department(4, "公关部"));
        departments.put(5, new Department(5, "管理部"));

    }

    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id获得部门
    public Department getDepartmentById(Integer deptId){
        return departments.get(deptId);
    }
}
