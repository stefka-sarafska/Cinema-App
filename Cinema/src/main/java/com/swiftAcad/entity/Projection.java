package com.swiftAcad.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Projection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cinema_name")
	@JsonIgnoreProperties({"projections","halls"})
	private Cinema cinema;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_name")
	@JsonIgnoreProperties("projections")
	private Movie movie;

	@Column
	private LocalDateTime projectionDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hall_name")
	@JsonIgnoreProperties({"projections","cinema","projection"})
	
	private Hall hall;

	public Projection() {
		super();
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDateTime getProjectionDate() {
		return projectionDate;
	}

	public void setProjectionDate(LocalDateTime projectionDate) {
		this.projectionDate = projectionDate;
	}

	public Hall getHall() {
		return hall;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}

}
