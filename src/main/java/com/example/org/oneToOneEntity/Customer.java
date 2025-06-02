package com.example.org.oneToOneEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String custName;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	@JsonBackReference
	private Orders order;
}
