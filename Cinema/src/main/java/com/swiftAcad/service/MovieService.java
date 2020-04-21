package com.swiftAcad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Movie;
import com.swiftAcad.entity.Projection;
import com.swiftAcad.exceptions.MovieException;
import com.swiftAcad.repository.MovieRepository;
import com.swiftAcad.repository.ProjectionRepository;

@Component
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private ProjectionRepository projectionRepo;

	public void addMovie(Movie movie) {
		movieRepo.save(movie);
	}

	public Movie findMovieByName(String name) throws MovieException {
		Movie movie = movieRepo.findByName(name);
		if (movie != null) {
			return movie;
		}
		throw new MovieException("Can not find movie with name " + name);
	}

	// update existing movie and add new movie if does't exist
	public Movie updateMovieOrAddNew(Movie movie) throws MovieException {
		Movie updatedMovie = movieRepo.save(movie);
		return updatedMovie;
	}

	public Movie updateExistingMovie(Movie newMovie) throws MovieException {
		Movie movie = findMovieByName(newMovie.getName());
		if (movie != null) {
			return movieRepo.save(newMovie);
		}
		throw new MovieException("Can not update movie with name: " + newMovie.getName() + ", because does not exist!");
	}

	//delete movie with projections
	public void deleteMovieByName(String name) {
		List<Projection> projections=projectionRepo.findAllByMovieName(name);
		for(Projection p:projections) {
			p.setCinema(null);
			p.setHall(null);
			p.setMovie(null);
			projectionRepo.delete(p);
		}
		Movie movie=movieRepo.findByName(name);
		movie.setProjections(null);
		movieRepo.deleteByName(name);
	}
}
