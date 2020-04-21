package com.swiftAcad.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Hall {
	@Transient
	private final static List<String> SEATS = new ArrayList<>(addingSeats());
	@Id
	private String name;

	@ElementCollection
	private List<String> seats = new ArrayList<>();

	@OneToMany(mappedBy = "hall")
	private List<Projection> projections;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cinema_name")
	private Cinema cinema;

	public Hall() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		seats = SEATS;
		this.seats = SEATS;
	}

	public List<Projection> getProjections() {
		return projections;
	}

	public void setProjections(List<Projection> projection) {
		this.projections = projection;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	private static List<String> addingSeats() {
		List<String> seats = new ArrayList<>();
		int rows = 15;
		for (char c = 'A'; c <= rows; ++c) {
			for (int i = 0; i < rows; i++) {
				String currSeat = String.valueOf(c + i);
				seats.add(currSeat);
			}
		}
		return seats;
	}

}
