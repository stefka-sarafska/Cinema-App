package com.swiftAcad.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.swiftAcad.entity.Projection;

@Repository
public interface ProjectionRepository extends CrudRepository<Projection, Long> {

	public List<Projection> findAllByProjectionDate(LocalDateTime projectionDate);
//	@Query
//	public Projection findByName(String name);
//	@Query
//	public List<Projection> findAllInGivenCinema(String cinemaName);

	public List<Projection> findAllProjectionByCinemaName(String cinema);

	@Modifying
	@Query("DELETE Projection p WHERE p.id = ?1")
	public void deleteById(long id);
}
