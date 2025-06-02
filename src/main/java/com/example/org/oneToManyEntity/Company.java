package com.example.org.oneToManyEntity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int compId;
	private String compName;
	
	@OneToMany(mappedBy = "company", cascade =CascadeType.ALL)
	@JsonBackReference(value="company-department")
	private List<Department> department;
}
