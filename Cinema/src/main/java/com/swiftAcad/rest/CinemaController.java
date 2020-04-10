package com.swiftAcad.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.service.CinemaService;

@Controller
@RequestMapping(value = "api")
public class CinemaController {
	
	@Autowired
	private CinemaService cinemaService;

	@RequestMapping(value = "cinema", method = RequestMethod.POST)
	public ResponseEntity<Cinema> addCinema(@RequestBody Cinema cinema) {
		cinemaService.addCinema(cinema);
		return new ResponseEntity<Cinema>(HttpStatus.CREATED);
	}

//	@RequestMapping(value = "cinema/{name}", method = RequestMethod.GET)
//	public ResponseEntity<Cinema> getCinemaByName(@PathVariable String name) {
//		Optional<Cinema> option = cinemaRepo.findByName(name);
//		if (!option.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		} else {
//
//			return new ResponseEntity<>(option.get(), HttpStatus.OK);
//		}
//	}

}
