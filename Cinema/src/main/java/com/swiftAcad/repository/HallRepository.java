package com.swiftAcad.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Hall;
@Repository
public interface HallRepository extends CrudRepository<Hall, Long>{
	
	public Optional<Hall> findByName(String name);
@Transactional
	public void deleteByName(String name);

}
