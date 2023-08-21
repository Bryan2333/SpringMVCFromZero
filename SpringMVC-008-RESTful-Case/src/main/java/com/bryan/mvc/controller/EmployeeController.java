package com.bryan.mvc.controller;

import com.bryan.mvc.bean.Employee;
import com.bryan.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    private EmployeeDao employeeDao;

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
    }

    // 显示所有员工信息
    @GetMapping("/employee")
    public String getAllEmployees(Model model) {
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList", employeeList);
        return "employee_list";
    }


    // 删除员工
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    // 添加员工
    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    // 根据ID获得员工信息
    @GetMapping("/employee/{id}")
    public String getEmployee(@PathVariable("id") Integer id, Model model) {
        Employee emp = employeeDao.get(id);
        model.addAttribute("employee", emp);
        return "employee_update";
    }

    // 更新员工信息
    @PutMapping("/employee")
    public String updateEmployee(Employee emp) {
        employeeDao.save(emp);
        return "redirect:/employee";
    }
}
