package com.swiftAcad.dto.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.swiftAcad.dto.ProjectionDto;
import com.swiftAcad.dto.service.ProjectionDtoService;

@Controller
public class ProjectionDtoController {

	@Autowired
	private ProjectionDtoService projectionDtoService;

	@GetMapping("/projection/projection")
	public ResponseEntity<List<ProjectionDto>> getInnerJoinData() {
		return new ResponseEntity<List<ProjectionDto>>(projectionDtoService.innerJoinData(), HttpStatus.OK);
	}

}
