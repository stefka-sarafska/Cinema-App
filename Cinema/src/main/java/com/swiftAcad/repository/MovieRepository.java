package com.swiftAcad.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Movie;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	public Optional<Movie> findByName(String name);

}
