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
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int prodId;
	private String prodName;
	
	@OneToOne(mappedBy = "product", cascade =CascadeType.ALL)
	@JsonBackReference(value = "product-order")
	private Orders order;
}
