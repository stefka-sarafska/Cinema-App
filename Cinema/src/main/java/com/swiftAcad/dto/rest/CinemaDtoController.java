package com.swiftAcad.dto.rest;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiftAcad.dto.CinemaDto;
import com.swiftAcad.dto.service.CinemaDtoService;

@RestController
public class CinemaDtoController {
	@Autowired
	private CinemaDtoService cinemaDtoService;

	@GetMapping("/cinema/cinema")
	public ResponseEntity<Set<CinemaDto>> getAllCinemaData() {
		return new ResponseEntity<>(cinemaDtoService.findCinemaData(), HttpStatus.OK);
	}
}
