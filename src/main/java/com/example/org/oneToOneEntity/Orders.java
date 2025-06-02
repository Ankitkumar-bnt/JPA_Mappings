package com.example.org.oneToOneEntity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cust_Id", referencedColumnName="custId")
	@JsonManagedReference
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="prod_Id", referencedColumnName = "prodId")
	@JsonManagedReference(value = "product-order")
	private Product product;

}
