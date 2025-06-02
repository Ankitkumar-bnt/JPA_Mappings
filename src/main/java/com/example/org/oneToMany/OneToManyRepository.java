package com.example.org.oneToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.org.oneToManyEntity.Employee;

@Repository
public interface OneToManyRepository extends JpaRepository<Employee, Integer>{

}
