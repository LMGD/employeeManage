package com.example.springboot.controller;

import com.example.springboot.dao.DepartmentDao;
import com.example.springboot.dao.EmployeeDao;
import com.example.springboot.pojo.Department;
import com.example.springboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author by LMGD
 * @date 2021-07-15 15:19
 * @description
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/list")
    public String list(Model model) {
        Collection<Employee> list = employeeDao.list();
        model.addAttribute("emps", list);

        //总数据
        model.addAttribute("total",employeeDao.list().size());
        return "/emp/list";
    }

    @RequestMapping("/toaddPage")
    public String toaddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "/emp/add";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeDao.add(employee);
        return "/emp/add";
    }

    @RequestMapping("/toeditPage/{empId}")
    public String toeditPage(@PathVariable("empId") Integer empId, Model model) {
        Employee employee = employeeDao.getEmployeeById(empId);
        model.addAttribute("emp", employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "/emp/edit";
    }

    @RequestMapping("/edit")
    public String edit(Employee employee) {
        employeeDao.edit(employee);
        return "redirect:/list";
    }

    @RequestMapping("/del/{empId}")
    public String delete(@PathVariable("empId") Integer empId) {
        employeeDao.delete(empId);
        return "redirect:/list";
    }
}
