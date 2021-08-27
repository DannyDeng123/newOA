package com.deng.newOA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.newOA.dao.DepartmentDao;
import com.deng.newOA.dao.EmployeeDao;
import com.deng.newOA.entity.Department;
import com.deng.newOA.entity.Employee;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private DepartmentDao departmentDao; 
	
	@GetMapping("/employees/{id}")
	public Employee test(@PathVariable long id) {
		return employeeDao.findById(id).get();
	}
	
	@GetMapping("/departments")
	public List<Department> getDepatments() {
		return departmentDao.findAll();
	}
}
