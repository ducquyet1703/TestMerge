package com.example.employeecrud.service;

import com.example.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getallEmployee();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
