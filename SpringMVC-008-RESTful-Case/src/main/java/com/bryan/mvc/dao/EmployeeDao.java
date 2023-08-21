package com.bryan.mvc.dao;

import com.bryan.mvc.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 模拟Dao层

@Repository
public class EmployeeDao {
    // <员工ID, 员工信息>
    private static final Map<Integer, Employee> employees = new HashMap<>();

    static {
        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
    }

    public EmployeeDao() {}

    private static Integer initId = 1006;

    public void save(Employee emp) {
        if (emp.getId() == null) {
            emp.setId(initId);
            initId++;
        }
        employees.put(emp.getId(), emp);
    }

    public Collection<Employee> getAll() {
        return employees.values();
    }

    // 根据ID获取员工信息
    public Employee get(Integer id) {
        return employees.get(id);
    }

    // 根据ID删除员工信息
    public void delete(Integer id) {
        employees.remove(id);
    }
}
