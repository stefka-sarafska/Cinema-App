package com.swiftAcad.repository;


import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Movie;
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	public Movie findByName(String name);
	  @Transactional
	@Modifying
	@Query("DELETE Movie p WHERE p.name = ?1")
	public void deleteByName(String name);

}
