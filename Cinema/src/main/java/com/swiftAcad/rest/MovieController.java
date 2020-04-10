package com.swiftAcad.rest;

import java.util.Optional;

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
import com.swiftAcad.repository.MovieRepository;
import com.swiftAcad.service.MovieService;

@Controller
@RequestMapping(value = "api")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "movie", method = RequestMethod.POST)
	public ResponseEntity<Cinema> addCinema(@RequestBody Movie movie) {
		movieService.addMovie(movie);
		return new ResponseEntity<Cinema>(HttpStatus.CREATED);
	}

//	@RequestMapping(value = "movie/{name}", method = RequestMethod.GET)
//	public ResponseEntity<Movie> getMovieByName(@PathVariable String name) {
//		Optional<Movie> movie = movieRepo.findByName(name);
//		if (!movie.isPresent()) {
//			return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<Movie>(movie.get(),HttpStatus.OK);
//		}
//	}

}
