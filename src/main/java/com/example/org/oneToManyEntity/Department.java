package com.example.org.oneToManyEntity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int deptId;
	private String deptName;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@JsonBackReference(value= "department-employee")
	private List<Employee> employee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="comp_Id",referencedColumnName = "compId")
	@JsonManagedReference(value= "company-department")
	private Company company;
}
