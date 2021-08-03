package com.example.springboot.dao;

import com.example.springboot.pojo.Department;
import com.example.springboot.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by LMGD
 * @date 2021-07-13 10:07
 * @description
 */
@Repository
public class DepartmentDao {

    //数据初始化
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<>();
        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "教研部"));
        departments.put(104, new Department(104, "运营部"));
        departments.put(105, new Department(105, "后勤部"));
    }

    //获取所有部门
    public Collection<Department> getDepartments() {
        return departments.values();
    }

    //查单个
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

    //add
    public void add(Department department) {
        departments.put(department.getId(), department);
    }

    //del
    public void delete(Integer id) {
        departments.remove(id);
    }
}
