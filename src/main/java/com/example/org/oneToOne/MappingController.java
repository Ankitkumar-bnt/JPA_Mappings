package com.example.org.oneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.org.oneToOneEntity.Customer;
import com.example.org.oneToOneEntity.Orders;
import com.example.org.oneToOneEntity.Product;

@RestController
public class MappingController {
	
	@Autowired
	private MappingRepository mappingRepository;
	
	
	
	@PostMapping("/add")
	public Customer add(@RequestParam String custName, @RequestParam String prodName) {
		
		Customer customer=new Customer();
		Product product=new Product();
		Orders orders=new Orders();
		
		
		customer.setCustName(custName);
		
		product.setProdName(prodName);
		
		orders.setCustomer(customer);
		orders.setProduct(product);
		
		customer.setOrder(orders);
		product.setOrder(orders);
		
		return mappingRepository.save(customer);
		
	}
}
