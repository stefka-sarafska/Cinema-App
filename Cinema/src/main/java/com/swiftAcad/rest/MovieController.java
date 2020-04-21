package com.swiftAcad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.entity.Movie;
import com.swiftAcad.exceptions.MovieException;
import com.swiftAcad.repository.MovieRepository;
import com.swiftAcad.service.MovieService;

@Controller
@RequestMapping(value = "api")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "movie", method = RequestMethod.POST)
	public ResponseEntity<Cinema> addMovie(@RequestBody Movie movie) {
		movieService.addMovie(movie);
		return new ResponseEntity<Cinema>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "movie", method = RequestMethod.PUT)
	public ResponseEntity<Movie> updateExistingMovieOrAddNew(@RequestBody Movie newMovie) {
		try {
			Movie updatedMovie = movieService.updateMovieOrAddNew(newMovie);
			return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
		} catch (MovieException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@RequestMapping(value = "movie/{name}", method = RequestMethod.GET)
	public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
		try {
			Movie movie = movieService.findMovieByName(name);
			return new ResponseEntity<>(movie, HttpStatus.OK);
		} catch (MovieException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "movie/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Movie> deleteMovie(@PathVariable String name) {
		movieService.deleteMovieByName(name);
		return new ResponseEntity<Movie>(HttpStatus.OK);
	}

}
