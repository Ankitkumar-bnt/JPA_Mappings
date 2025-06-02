package com.example.org.oneToMany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.org.oneToManyEntity.Company;
import com.example.org.oneToManyEntity.Department;
import com.example.org.oneToManyEntity.Employee;

@RestController
public class OneToManyController {

	@Autowired
	private OneToManyRepository oneToManyRepository;
	
	@PostMapping("/addEmp")
	public Employee add(@RequestParam String empName,@RequestParam String deptName, 
					@RequestParam String compName) {
		
		Employee emp=new Employee();
		Department dept=new Department();
		Company comp=new Company();
		
		List<Employee> empList=new ArrayList<>();
		empList.add(emp);
		
		List<Department> deptList=new ArrayList<>();
		deptList.add(dept);
		
		emp.setEmpName(empName);
		dept.setDeptName(deptName);
		comp.setCompName(compName);
		
		emp.setDepartment(dept);
		dept.setCompany(comp);
		dept.setEmployee(empList);
		comp.setDepartment(deptList);
		
		return oneToManyRepository.save(emp);
		
	}
}
