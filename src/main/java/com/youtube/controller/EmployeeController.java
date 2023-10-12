package com.youtube.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.model.Employee;
import com.youtube.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empservice;

	@GetMapping("/home")
	public String homePage() {
		return "welcome";
	}

	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emplyee) {

		Employee emp = empservice.addEmployee(emplyee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@DeleteMapping("/removeEmp")
	public ResponseEntity<String> removeEmployee(@PathVariable int id) {

		empservice.removeEmployee(id);
		return new ResponseEntity<String>("remove succ", (HttpStatus.ACCEPTED));
	}

	@GetMapping("/findEmp")
	public ResponseEntity<Optional<Employee>> findById(@PathVariable int id) {

		Optional<Employee> emp1 = empservice.findEmpById(id);
		return new ResponseEntity<Optional<Employee>>(emp1, HttpStatus.ACCEPTED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Employee>> listOfEmployee() {

		List<Employee> Emp2 = empservice.getAllEmployee();

		return new ResponseEntity<List<Employee>>(Emp2, HttpStatus.ACCEPTED);
	}

}
