package com.example.org.manyToMany;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.org.manyToManyEntity.Casts;
import com.example.org.manyToManyEntity.Genre;
import com.example.org.manyToManyEntity.Movie;

@RestController
public class ManyToManyController {

	@Autowired
	ManyToManyRepository repo;
	
	@PostMapping("/addMovie")
	public Movie addMovie(@RequestParam String movieName, @RequestParam String castName, @RequestParam String genreName)
	{
		Movie movie = new Movie();
		Casts cast = new Casts();
		Genre genre = new Genre();
		
		movie.setMovieName(movieName);
		cast.setCastName(castName);
		genre.setGenreName(genreName);
		
		Set<Casts> castSet = new HashSet<>();
		castSet.add(cast);
		
		Set<Genre> genreSet = new HashSet<>();
		genreSet.add(genre);
		
		movie.setCastList(castSet);
		movie.setGenreList(genreSet);
		
		Movie save = repo.save(movie);
		return save;
	}
}
