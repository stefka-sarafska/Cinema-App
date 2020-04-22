package com.swiftAcad.dto.respository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.swiftAcad.dto.MovieDto;
import com.swiftAcad.entity.Movie;

public interface MovieDtoRespository extends JpaRepository<Movie, String> {

	@Query("SELECT new com.swiftAcad.dto.MovieDto(m.name,m.actors,m.description,m.format,m.genre,m.premiereDate,p.projectionDate)"
			+ "FROM Movie m INNER JOIN m.projections p")
	public List<MovieDto> fetchAllData();
	@Query("SELECT new com.swiftAcad.dto.MovieDto(m.name,m.actors,m.description,m.format,m.genre,m.premiereDate)"
			+ "FROM Movie m")
	public List<MovieDto> fetchAllMoviesWithOutProjections();
		
}
