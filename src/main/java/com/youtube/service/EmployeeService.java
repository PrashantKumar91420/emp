package com.youtube.service;

import java.util.List;
import java.util.Optional;

import com.youtube.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee); // add method employee ko add karna kaliya (return object types)

	public String removeEmployee(int id); // remove method return the string

	public  Optional<Employee> findEmpById(int id);

	public List<Employee> getAllEmployee(); // employee list to all(i am using in collection)

	public String updateEmployee(int id); // update method

}
