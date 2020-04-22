package com.swiftAcad.dto.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swiftAcad.dto.CinemaDto;
import com.swiftAcad.entity.Cinema;

public interface CinemaDtoRespository extends JpaRepository<Cinema, Long> {
	@Query("SELECT new com.swiftAcad.dto.CinemaDto(c.name,con.email,con.address,con.phone,h.name,m.name)"
			+ "FROM Cinema c INNER JOIN c.projections p INNER JOIN c.halls h INNER JOIN c.contact con INNER JOIN p.movie m")
	List<CinemaDto> fetchCinemaData();

	@Query("SELECT new com.swiftAcad.dto.CinemaDto(c.name,con.email,con.address,con.phone,h.name)"
			+ " FROM Cinema c INNER JOIN c.halls h INNER JOIN c.contact con")
	List<CinemaDto> fetchCinemaDataWithOutProjections();
}
