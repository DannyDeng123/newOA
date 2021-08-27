package com.deng.newOA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deng.newOA.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
	Employee findByUidAndPassword(Long uid, String password);
}
