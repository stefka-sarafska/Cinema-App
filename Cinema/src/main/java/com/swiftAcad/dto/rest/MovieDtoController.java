package com.swiftAcad.dto.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiftAcad.dto.MovieDto;
import com.swiftAcad.dto.service.MovieDtoService;

@RestController
public class MovieDtoController {

	@Autowired
	private MovieDtoService movieDtoService;
	
	@GetMapping("/movie/movie")
	public ResponseEntity<Set<MovieDto>> getAllMovieData(){
		return new ResponseEntity<>(movieDtoService.findAllMovieData(),HttpStatus.OK);
	}
	
}
