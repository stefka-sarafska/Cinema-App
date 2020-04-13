package com.swiftAcad.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.entity.Hall;
import com.swiftAcad.repository.CinemaRepository;

@Component
public class CinemaService {

	@Autowired
	private CinemaRepository cinemaRepo;

	public void addCinema(Cinema cinema) {
		for (Hall h : cinema.getHalls()) {
			h.setCinema(cinema);
		}
		cinemaRepo.save(cinema);
	}
	public Optional<Cinema> getCinemaByName(String name) {
		Optional<Cinema> cinema=cinemaRepo.findByName(name);
		return cinema;
	}

		
	}
