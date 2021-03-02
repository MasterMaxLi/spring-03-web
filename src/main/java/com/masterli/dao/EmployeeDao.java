package com.masterli.dao;

import com.masterli.pojo.Department;
import com.masterli.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Creqated by Limingxuan on 2021/2/28
 */
@Repository
public class EmployeeDao {

    //模拟数据库中的数据

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "张三", "zhangsan@qq.com", 1, new Department(1, "技术部"), new Date()));
        employees.put(1002, new Employee(1002, "李四", "lisi@163.com", 1, new Department(2, "研发部"), new Date()));
        employees.put(1003, new Employee(1003, "王二", "wanger@gmail.com", 1, new Department(3, "售后部"), new Date()));
        employees.put(1004, new Employee(1004, "麻子", "mazi@outlook.com", 1, new Department(4, "公关部"), new Date()));
        employees.put(1005, new Employee(1005, "小红", "xiaohong@pega.com", 0, new Department(5, "管理部"), new Date()));
    }

    //主键自增
    private static Integer initId = 1006;

    public void add(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getDeptId()));

        employees.put(employee.getId(), employee);
    }

    //查询所有员工
    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public int deleteEmployeeById(Integer id){
        if(getEmployeeById(id) == null)
            //员工不存在，删除失败返回0
            return 0;
        else {
            //员工存在，删除成功返回1
            employees.remove(id);
            return 1;
        }
    }
}
