package com.swiftAcad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Movie;
import com.swiftAcad.exceptions.MovieException;
import com.swiftAcad.repository.MovieRepository;

@Component
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;

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

	public void deleteMovieByName(String name) {
		movieRepo.deleteByName(name);
	}
}
