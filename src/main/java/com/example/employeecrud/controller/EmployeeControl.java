package com.example.employeecrud.controller;

import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeControl {

	// Test Megre
	private final EmployeeService employeeService;

	public EmployeeControl(EmployeeService employeeService) {this.employeeService = employeeService;}

	@Operation(summary = "Tạo mới một nhân viên")
	@PostMapping("/saveEmployees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@Operation(summary = "Lấy danh sách tất cả nhân viên")
	@GetMapping("/getall-employee")
	public List<Employee> getallEmploy(){
		return employeeService.getallEmployee();
	}

	@Operation(summary = "Tìm nhân viên theo id")
	@GetMapping("/findById-employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	@Operation(summary = "Cập nhập thông tin nhân viên")
	@PutMapping("/update-employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
		return  new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@Operation(summary = "Xoá thông tin nhân viên")
	@DeleteMapping("/delete-employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted success", HttpStatus.OK);
	}
}
