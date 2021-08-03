package com.example.springboot.dao;

import com.example.springboot.pojo.Department;
import com.example.springboot.pojo.Employee;
import com.example.springboot.util.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by LMGD
 * @date 2021-07-13 10:07
 * @description
 */
@Repository
public class EmployeeDao {

    //数据初始化
    private static Map<Integer, Employee> map = null;

    @Autowired
    private DepartmentDao departmentDao;

    //员工id自增
    private static Integer id = 1005;

    static {
        map = new HashMap<Integer, Employee>();
        map.put(1001, new Employee(1001, "邓林妹", "111111@qq.com", 1, new Department(101, "教学部")));
        map.put(1002, new Employee(1002, "晚安", "111111@qq.com", 0, new Department(102, "市场部")));
        map.put(1003, new Employee(1003, "小小", "111111@qq.com", 0, new Department(103, "教研部")));
        map.put(1004, new Employee(1004, "明明", "111111@qq.com", 1, new Department(104, "运营部")));
        map.put(1005, new Employee(1005, "LMGD", "111111@qq.com", 1, new Department(105, "后勤部")));
    }

    //add
    public void add(Employee employee) {
        if (null == employee.getId()) {
            id++;
        }
        employee.setId(id);
        Integer deptId = employee.getDepartment().getId();
        employee.setDepartment(departmentDao.getDepartmentById(deptId));
        map.put(employee.getId(), employee);
    }

    public Collection<Employee> list() {
        return map.values();
    }

    public Employee getEmployeeById(Integer id) {
        return map.get(id);
    }

    public void edit(Employee employee) {
        Integer employeeId = employee.getId();
        Employee emp = map.get(employeeId);

        String lastName = employee.getLastName();
        Integer gender = employee.getGender();
        String email = employee.getEmail();
        Date birth = employee.getBirth();
        Department department = employee.getDepartment();
        Integer deptId = department.getId();

        if (StrUtils.isNotEmpty(lastName)) {
            emp.setLastName(lastName);
        }
        if (StrUtils.isNotEmpty(gender)) {
            emp.setGender(gender);
        }
        if (StrUtils.isNotEmpty(email)) {
            emp.setEmail(email);
        }
        if (StrUtils.isNotEmpty(birth)) {
            emp.setBirth(birth);
        }
        if (StrUtils.isNotEmpty(deptId)) {
            emp.setDepartment(departmentDao.getDepartmentById(deptId));
        }
    }

    public void delete(Integer id) {
        map.remove(id);
    }
}
