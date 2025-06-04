package com.example.org.manyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.org.manyToManyEntity.Movie;

@Repository
public interface ManyToManyRepository extends JpaRepository<Movie, Integer>{

}
