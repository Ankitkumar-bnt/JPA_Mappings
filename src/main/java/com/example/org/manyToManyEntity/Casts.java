package com.example.org.manyToManyEntity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Casts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int castId;
	private String castName;
	
	@ManyToMany(mappedBy = "castList")
//	@JsonBackReference("casts-movie")
	@JsonIgnore
	private Set<Movie> cMovie = new HashSet<>();
}
