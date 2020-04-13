package com.swiftAcad.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Hall;
@Repository
public interface HallRepository extends CrudRepository<Hall, Long>{
	
	public Optional<Hall> findByName(String name);

}
