package com.swiftAcad.dto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftAcad.dto.ProjectionDto;
import com.swiftAcad.dto.respository.ProjectionDtoRespository;

@Service
public class ProjectionDtoService {

	@Autowired
	private ProjectionDtoRespository projectionDtoRespository;

	public List<ProjectionDto> innerJoinData() {
		return projectionDtoRespository.fetchDataInnerJoin();
	}

}
