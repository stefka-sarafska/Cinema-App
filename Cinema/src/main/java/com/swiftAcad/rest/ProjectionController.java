package com.swiftAcad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.entity.Projection;
import com.swiftAcad.service.ProjectionService;

@Controller
@RequestMapping(value = "api")
public class ProjectionController {
	
	@Autowired
	private ProjectionService projectionService;
	
	@RequestMapping(value = "projection", method = RequestMethod.POST)
	public ResponseEntity<Cinema> addCinema(@RequestBody Projection projection) {
		projectionService.addProjection(projection);
		return new ResponseEntity<Cinema>(HttpStatus.CREATED);
	}

}
