package com.swiftAcad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Movie;
import com.swiftAcad.repository.MovieRepository;

@Component
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;

	public void addMovie(Movie movie) {
		movieRepo.save(movie);
	}
	
//	public void deleteMovieByName(String name) {
//		movieRepo.delete(entity);
//	}
}
