package com.masterli.controller;

import com.masterli.dao.DepartmentDao;
import com.masterli.dao.EmployeeDao;
import com.masterli.pojo.Department;
import com.masterli.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * Creqated by Limingxuan on 2021/3/1
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAllEmployee();
        model.addAttribute("employees", employees);
        return "emp/list";
    }

    //跳转到员工添加页面
    @GetMapping("/emp")
    public String toAddEmployeePage(Model model){
        //查出所有部门数据
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        System.out.println("employee: " + employee);
        //添加员工
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    //跳转到员工修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmployeePage(@PathVariable("id") Integer id, Model model){
        //查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("employee", employee);
        return "emp/update";
    }

    //修改员工信息
    @PostMapping("/updateemp")
    public String updateEmployee(Employee employee){
        employeeDao.add(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/deleteemp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps";
    }
}
