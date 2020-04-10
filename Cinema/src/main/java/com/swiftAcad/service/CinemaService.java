package com.swiftAcad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.entity.Contact;
import com.swiftAcad.entity.Hall;
import com.swiftAcad.entity.Movie;
import com.swiftAcad.entity.Projection;
import com.swiftAcad.repository.CinemaRepository;
import com.swiftAcad.repository.ContactRepository;
import com.swiftAcad.repository.HallRepository;
import com.swiftAcad.repository.MovieRepository;
import com.swiftAcad.repository.ProjectionRepository;

@Component
public class CinemaService {

	@Autowired
	private CinemaRepository cinemaRepo;
	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private HallRepository hallRepo;
	@Autowired
	private ProjectionRepository projectionRepo;

	public void addCinema(Cinema cinema) {
		Cinema newCinema = cinemaRepo.save(cinema);
		Contact contact = newCinema.getContact();
		contact.setCinema(newCinema);
		contactRepo.save(contact);
		for (Projection projection : newCinema.getProjections()) {
			projection.setCinema(newCinema);
			Projection p = projectionRepo.save(projection);
			Movie movie = p.getMovie();
			movieRepo.save(movie);
		}
		for (Hall hall : newCinema.getHalls()) {
			hall.setCinema(newCinema);
			hallRepo.save(hall);
		}

	}

}
