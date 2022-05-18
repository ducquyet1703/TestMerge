package com.example.employeecrud.service.impl;

import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.exception.ResourceNotFoundExecption;
import com.example.employeecrud.repository.EmployeeRepository;
import com.example.employeecrud.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {this.employeeRepository = employeeRepository;}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getallEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()){
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundExecption("Employeee","Id", id);
//		}
		return employeeRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundExecption("Employee", "Id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(() ->
							   new ResourceNotFoundExecption("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() ->
						 new ResourceNotFoundExecption("Employee", "Id", id));

		employeeRepository.deleteById(id);
	}
}
