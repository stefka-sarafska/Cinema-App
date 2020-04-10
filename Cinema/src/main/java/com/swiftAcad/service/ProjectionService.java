package com.swiftAcad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
public class ProjectionService {

	@Autowired
	private ProjectionRepository projectionRepo;
	@Autowired
	private CinemaRepository cinemaRepo;
	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private HallRepository hallRepo;

	public void addProjection(Projection projection) {
		Projection newProjection = projectionRepo.save(projection);
		Cinema cinema = newProjection.getCinema();
		Contact contact = cinema.getContact();
		contact.setCinema(cinema);
		Cinema newCinema = cinemaRepo.save(cinema);
		contactRepo.save(contact);
		
		for (Hall h : cinema.getHalls()) {
			h.setCinema(newCinema);
			hallRepo.save(h);
			Movie movie = newProjection.getMovie();
			Movie newMovie = movieRepo.save(movie);
			for (Projection p : movie.getProjections()) {
				p.setMovie(newMovie);
				projectionRepo.save(p);
			}
			for (Projection p : cinema.getProjections()) {
				p.setCinema(newCinema);
				p.setHall(h);
				p.setMovie(newMovie);
				projectionRepo.save(p);
			}
		}
		

		
		

	}

}
