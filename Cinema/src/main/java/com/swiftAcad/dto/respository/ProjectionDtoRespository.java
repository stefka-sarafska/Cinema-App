package com.swiftAcad.dto.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swiftAcad.dto.ProjectionDto;
import com.swiftAcad.entity.Projection;

public interface ProjectionDtoRespository extends JpaRepository<Projection, Long> {

	@Query("SELECT new com.swiftAcad.dto.ProjectionDto(p.id,c.name,m.name,h.name,p.projectionDate)"
			+ "FROM Projection p INNER JOIN p.cinema c INNER JOIN p.movie m INNER JOIN p.hall h")
	List<ProjectionDto> fetchDataInnerJoin();

}
