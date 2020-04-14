package com.swiftAcad.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Cinema;

@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Long> {

	public Cinema findByName(String name);
	@Transactional
	@Modifying
	public void deleteByName(String name);



}
