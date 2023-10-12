package com.youtube.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.model.Employee;
import com.youtube.repository.EmployeeRepo;
import com.youtube.service.EmployeeService;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;    // reference repository ka

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepo.save(employee); // data ko save
		return emp;
		
	}

	@Override
	public String removeEmployee(int id) {
		employeeRepo.deleteById(id);
		return " Delete data";
	}

	@Override
	public Optional<Employee> findEmpById(int id) {
		Optional<Employee> emp1 = employeeRepo.findById(id);

		if (emp1.isPresent()) {
			return emp1;

		}
		else {
			
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployee() {
		 List<Employee> empList =employeeRepo.findAll();
			return empList;
	}

	@Override
	public String updateEmployee(int id) {
		Optional<Employee> emp=employeeRepo.findById(id);
	    
	    if(emp.isPresent()) {
	    	Employee emps =new Employee();
	    	
	    	employeeRepo.save(emps);
	    	return "updateb";
	    	
	    }
	    else {
	    	return "Employee not found";
	    }

}
}
