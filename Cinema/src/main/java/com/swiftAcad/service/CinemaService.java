package com.swiftAcad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.entity.Contact;
import com.swiftAcad.entity.Hall;
import com.swiftAcad.entity.Projection;
import com.swiftAcad.exceptions.CinemaException;
import com.swiftAcad.repository.CinemaRepository;
import com.swiftAcad.repository.ContactRepository;
import com.swiftAcad.repository.HallRepository;
import com.swiftAcad.repository.ProjectionRepository;

@Component
public class CinemaService {
	private final static String PASS_FOR_DELETE = "129s";

	@Autowired
	private CinemaRepository cinemaRepo;
	@Autowired
	private ContactRepository contactRepo;
	@Autowired
	private ProjectionRepository projectionRepo;
	@Autowired
	private HallRepository hallRepository;

	public void addCinema(Cinema cinema) throws CinemaException {
		if (ContactService.isValidEmail(cinema.getContact().getEmail())
				&& ContactService.isValidPhoneNumber(cinema.getContact().getPhone())) {
			for (Hall h : cinema.getHalls()) {
				h.setCinema(cinema);
			}
			cinemaRepo.save(cinema);
		} else {
			throw new CinemaException(
					"Can not add new cinema in DB, because contact email or phone number are invalid!");
		}
	}

	public Cinema findCinemaByName(String name) throws CinemaException {
		Cinema cinema = cinemaRepo.findByName(name);
		if (cinema != null) {
			return cinema;
		}
		throw new CinemaException("Can not find cinema with name " + name);
	}

	public Cinema updateCinema(Cinema cinema) throws CinemaException {
		Cinema updatedCinema = cinemaRepo.save(cinema);
		return updatedCinema;
	}

	public void deleteCinema(String password, String name) throws CinemaException {
		if (password.equals(PASS_FOR_DELETE)) {
			Cinema cinema = cinemaRepo.findByName(name);
			Contact contact = cinema.getContact();
			List<Projection> projections = cinema.getProjections();
			List<Hall> halls = cinema.getHalls();

			cinema.setContact(null);
			cinema.setProjections(null);
			cinema.setHalls(null);

			for (Projection p : projections) {
				p.setCinema(null);
				p.setHall(null);
				p.setMovie(null);
				projectionRepo.deleteById(p.getId());

			}
			for (Hall h : halls) {
				h.setCinema(null);
				h.setProjections(null);
				h.setSeats(null);
				hallRepository.deleteByName(h.getName());
			}
			cinemaRepo.delete(cinema);
			contact.setCinema(null);
			contactRepo.delete(contact);

		} else {
			throw new CinemaException("Invalid password for deleting cinema " + name);
		}
	}

}
