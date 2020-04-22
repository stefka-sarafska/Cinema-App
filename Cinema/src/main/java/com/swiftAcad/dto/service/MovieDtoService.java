package com.swiftAcad.dto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftAcad.dto.CinemaDto;
import com.swiftAcad.dto.MovieDto;
import com.swiftAcad.dto.respository.MovieDtoRespository;

@Service
public class MovieDtoService {

	@Autowired
	private MovieDtoRespository movieDtoRespository;

	public Set<MovieDto> findAllMovieData() {
		List<MovieDto> movies = movieDtoRespository.fetchAllData();
		List<MovieDto> findedMovies = new ArrayList<MovieDto>();
		if (!movies.isEmpty()) {
			for (int i = 1; i < movies.size(); i++) {
				MovieDto prevMovie = movies.get(i - 1);
				MovieDto currMovie = movies.get(i);
				List<MovieDto> currMovies = MovieDto.compareTo(prevMovie, currMovie);
				findedMovies.addAll(currMovies);
			}
			if(movies.size()==1) {
				findedMovies.addAll(movies);
			}
		}
		return new HashSet<>(findedMovies);
	}
	
	public List<MovieDto> findAllMoviesWithoutProjections(){
		return movieDtoRespository.fetchAllMoviesWithOutProjections();
	}
}
