package com.example.org.manyToManyEntity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieName;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="movie_casts",
	joinColumns = @JoinColumn(name = "movie_id"),
	inverseJoinColumns = @JoinColumn(name = "cast_id"))
//	@JsonManagedReference("casts-movie")
	private Set<Casts> castList = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "movie_genre",
	joinColumns = @JoinColumn(name="movie_id"),
	inverseJoinColumns = @JoinColumn(name="genre_id"))
//	@JsonManagedReference("genre-movie")
	private Set<Genre> genreList = new HashSet<>();
}
