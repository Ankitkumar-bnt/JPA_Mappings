package com.example.org.manyToManyEntity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Movie {
	private int movieId;
	private String movieName;
}
