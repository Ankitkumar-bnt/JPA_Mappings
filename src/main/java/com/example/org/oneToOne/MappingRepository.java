package com.example.org.oneToOne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.org.oneToOneEntity.Customer;

@Repository
public interface MappingRepository extends JpaRepository<Customer, Integer>{

}
