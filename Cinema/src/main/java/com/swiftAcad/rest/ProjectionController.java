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
import com.swiftAcad.exceptions.CinemaException;
import com.swiftAcad.exceptions.DateException;
import com.swiftAcad.exceptions.HallException;
import com.swiftAcad.exceptions.MovieException;
import com.swiftAcad.exceptions.ProjectionException;
import com.swiftAcad.service.ProjectionService;

@Controller
@RequestMapping(value = "api")
public class ProjectionController {

	@Autowired
	private ProjectionService projectionService;

	@RequestMapping(value = "projection", method = RequestMethod.POST)
	public ResponseEntity<Projection> addProjection(@RequestBody Projection projection) {
		try {
			projectionService.addProjection(projection);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (CinemaException | HallException | MovieException | DateException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "projections/cinema/{cinemaName}", method = RequestMethod.GET)
	public ResponseEntity<List<Projection>> getAllProjectinsInCinema(@PathVariable String cinemaName) {
		try {
			List<Projection> projections = projectionService.findAllProjectionByCinemaName(cinemaName);
			return new ResponseEntity<>(projections, HttpStatus.FOUND);
		} catch (ProjectionException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "projection/id/{id}")
	public ResponseEntity<Projection> deleteProjection(@PathVariable long id) {
		projectionService.deleteProjectionById(id);
		return new ResponseEntity<Projection>(HttpStatus.OK);
	}

	@RequestMapping(value = "projections/date/{date}", method = RequestMethod.GET)
	public ResponseEntity<List<Projection>> getProjectionsByDate(
			@PathVariable("date") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime date) {
		try {
			List<Projection> foundedProjections = projectionService.findProjectionsByProjectionDateAndTime(date);
			return new ResponseEntity<>(foundedProjections, HttpStatus.FOUND);
		} catch (ProjectionException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "projection/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<Projection>> getProjectionByMovieName(@PathVariable String name) {
		try {
			List<Projection> projections = projectionService.findProjectionsByMovieName(name);
			return new ResponseEntity<>(projections, HttpStatus.FOUND);
		} catch (ProjectionException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "projection/id/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProjectById(@PathVariable long id) {
		projectionService.deleteProjectionById(id);
		return new ResponseEntity<>("Projection deleted successfully!", HttpStatus.OK);
	}

}
