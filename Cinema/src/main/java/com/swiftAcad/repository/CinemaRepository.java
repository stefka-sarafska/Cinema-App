package com.swiftAcad.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Cinema;
@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long>{
	public Optional<Cinema> findByName(String name);

}
