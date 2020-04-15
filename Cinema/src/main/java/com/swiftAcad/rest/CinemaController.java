package com.swiftAcad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.exceptions.CinemaException;
import com.swiftAcad.service.CinemaService;

@Controller
@RequestMapping(value = "api")
public class CinemaController {

	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value = "cinema", method = RequestMethod.POST)
	public ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema) {
		try {
			cinemaService.addCinema(cinema);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (CinemaException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Cinema>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "cinema/{name}", method = RequestMethod.GET)
	public ResponseEntity<Cinema> getCinema(@PathVariable String name) {
		try {
			Cinema cinema = cinemaService.findCinemaByName(name);
			return new ResponseEntity<>(cinema, HttpStatus.OK);
		} catch (CinemaException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Cinema>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "cinema", method = RequestMethod.PUT)
	public ResponseEntity<Cinema> updateCinema(@RequestBody Cinema cinema) {
		try {
			Cinema updatedCinema = cinemaService.updateCinema(cinema);
			return new ResponseEntity<>(updatedCinema, HttpStatus.OK);
		} catch (CinemaException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "cinema/delete/{name}",method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCinema(@PathVariable("name") String name) {
		try {
			cinemaService.deleteCinema("129s", name);
			return new ResponseEntity<>("Successfull delete cinema " + name, HttpStatus.OK);
		} catch (CinemaException e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Deleting failure!", HttpStatus.BAD_REQUEST);
		}
	}

}
