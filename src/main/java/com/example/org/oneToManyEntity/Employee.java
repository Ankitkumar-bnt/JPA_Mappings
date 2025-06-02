package com.example.org.oneToManyEntity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dept_Id",referencedColumnName = "deptId")
	@JsonManagedReference(value="department-employee")
	private Department department;
}
