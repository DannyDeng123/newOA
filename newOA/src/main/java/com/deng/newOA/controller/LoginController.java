package com.deng.newOA.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deng.newOA.dao.EmployeeDao;
import com.deng.newOA.entity.Employee;


@Controller
@RequestMapping("/new_OA")
public class LoginController {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginPost(@RequestParam Long username,
							@RequestParam String password,
							HttpSession session) {
		Employee employee = employeeDao.findByUidAndPassword(username, password);
		if(employee != null) {
			session.setAttribute("employee", employee);
			return "index";
		}
		return "login";
	}
}
