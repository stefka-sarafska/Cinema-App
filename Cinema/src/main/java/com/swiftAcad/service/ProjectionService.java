package com.swiftAcad.service;

import java.time.LocalDateTime;
import java.util.List;

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

	public List<Projection> findAllProjectionsInGivenCinema(String cinemaName) {
		List<Projection> projections = projectionRepo.findAllInGivenCinema(cinemaName);
		return projections;
	}

	public Projection findProjectionByName(String name) {
		Projection projection = projectionRepo.findByName(name);
		return projection;
	}

	public List<Projection> findProjectionsByDate(LocalDateTime projectionDate) {
		List<Projection> projectionsOnDate = projectionRepo.findByDate(projectionDate);
		return projectionsOnDate;
	}

	public static boolean validateProjectionDate(Projection projection) {
		LocalDateTime currentDate = LocalDateTime.now();
		if (projection.getProjectionDateAndTime().isAfter(currentDate)
				|| projection.getProjectionDateAndTime().equals(currentDate)) {
			return true;
		} else {
			return false;
		}
	}

}
