package com.swiftAcad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Movie;
import com.swiftAcad.entity.Projection;
import com.swiftAcad.repository.MovieRepository;
import com.swiftAcad.repository.ProjectionRepository;

@Component
public class MovieService {
	
@Autowired
private MovieRepository movieRepo;
@Autowired
private ProjectionRepository projectionRepo;

	public void addMovie(Movie movie) {
		Movie newMovie=movieRepo.save(movie);
		for(Projection p:newMovie.getProjections()) {
			p.setMovie(newMovie);
			projectionRepo.save(p);
			
		}
	}
}
