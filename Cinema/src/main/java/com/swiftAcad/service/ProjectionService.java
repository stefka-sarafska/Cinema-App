package com.swiftAcad.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.entity.Hall;
import com.swiftAcad.entity.Movie;
import com.swiftAcad.entity.Projection;
import com.swiftAcad.repository.CinemaRepository;
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
	private MovieRepository movieRepo;
	@Autowired
	private HallRepository hallRepo;

	public void addProjection(Projection projection) {
		if (validateProjectionDate(projection)) {
			Optional<Cinema> cinema = cinemaRepo.findByName(projection.getCinema().getName());
			if (cinema.isPresent()) {
				projection.setCinema(cinema.get());
			} else {
				// throw new exception
			}
			Optional<Hall> hall = hallRepo.findByName(projection.getHall().getName());
			if (hall.isPresent()) {
				projection.setHall(hall.get());
			} else {
				// throw new exception
			}
			Optional<Movie> movie = movieRepo.findByName(projection.getMovie().getName());
			if (movie.isPresent()) {
				projection.setMovie(movie.get());
			} else {
				// throw new exception
			}
			projectionRepo.save(projection);
		}
	}

//	public List<Projection> findAllProjectionsInGivenCinema(String cinemaName) {
//		List<Projection> projections = projectionRepo.findAllInGivenCinema(cinemaName);
//		return projections;
//	}
//
//	public Projection findProjectionByName(String name) {
//		Projection projection = projectionRepo.findByName(name);
//		return projection;
//	}
//
	public List<Projection> findProjectionsByProjectionDateAndTime(LocalDateTime projectionDateAndTime) {
		List<Projection> projectionsOnDate = projectionRepo.findAllByProjectionDate(projectionDateAndTime);
		return projectionsOnDate;
	}

//
//	public void deleteProjectById(long id) {
//		projectionRepo.deleteById(id);
//	}
//
	public static boolean validateProjectionDate(Projection projection) {
		LocalDateTime currentDate = LocalDateTime.now();
		if (projection != null && (projection.getProjectionDate().isAfter(currentDate)
				|| projection.getProjectionDate().equals(currentDate))) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteProjectionById(long id) {
		projectionRepo.deleteById(id);
	}

	public List<Projection> findAllProjectionByCinemaName(String cinema) {
		List<Projection> projections = projectionRepo.findAllProjectionByCinemaName(cinema);
		return projections;

	}

}
