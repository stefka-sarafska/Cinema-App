package com.swiftAcad.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swiftAcad.entity.Projection;
import com.swiftAcad.service.ProjectionService;

@Controller
@RequestMapping(value = "api")
public class ProjectionController {

	@Autowired
	private ProjectionService projectionService;

	@RequestMapping(value = "projection", method = RequestMethod.POST)
	public ResponseEntity<Projection> addProjection(@RequestBody Projection projection) {
		projectionService.addProjection(projection);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "projections/{cinemaName}", method = RequestMethod.GET)
	public ResponseEntity<List<Projection>> getAllProjectinsInCinema(@PathVariable String cinemaName) {
		List<Projection> projections = projectionService.findAllProjectionByCinemaName(cinemaName);
		if (projections.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(projections, HttpStatus.FOUND);
	}
	@RequestMapping(value="projection/id/{id}")
	public ResponseEntity<Projection> deleteProjection(@PathVariable long id){
		projectionService.deleteProjectionById(id);
		return new ResponseEntity<Projection>(HttpStatus.OK);
	}

//	@RequestMapping(value = "projections/{date}", method = RequestMethod.GET)
//	public ResponseEntity<List<Projection>> getProjectionsByDate(@PathVariable("date")  @DateTimeFormat(iso = ISO.DATE_TIME)  LocalDateTime date) {
//		List<Projection> foundedProjections = projectionService.findProjectionsByProjectionDateAndTime(date);
//		if (foundedProjections.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<>(foundedProjections, HttpStatus.FOUND);
//		}
//	}
//
//	@RequestMapping(value = "projection/{name}", method = RequestMethod.GET)
//	public ResponseEntity<Projection> getProjectionByName(@PathVariable String name) {
//		Projection projection = projectionService.findProjectionByName(name);
//		if (projection == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<>(projection, HttpStatus.FOUND);
//	}
//
//	@RequestMapping(value = "projections/cinema/{name}", method = RequestMethod.GET)
//	public ResponseEntity<List<Projection>> getProjectionsByCinemaName(@PathVariable String cinemaName) {
//		List<Projection> projections = projectionService.findAllProjectionsInGivenCinema(cinemaName);
//		if (projections.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//			return new ResponseEntity<>(projections, HttpStatus.FOUND);
//		}
//	}
//
//	@RequestMapping(value = "project/id/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Projection> deleteProjectById(@PathVariable long id) {
//		projectionService.deleteProjectById(id);
//		return new ResponseEntity<Projection>(HttpStatus.OK);
//	}

}
