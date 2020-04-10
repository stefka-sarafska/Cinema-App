package com.swiftAcad.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Projection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "cinema_name",insertable=false, updatable=false)
	private Cinema cinema;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_name",insertable=false, updatable=false)
	private Movie movie;

	@Column
	private LocalDateTime projectionDateAndTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hall_name",insertable=false, updatable=false)
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

	public LocalDateTime getProjectionDateAndTime() {
		return projectionDateAndTime;
	}

	public void setProjectionDateAndTime(LocalDateTime projectionDateAndTime) {
		this.projectionDateAndTime = projectionDateAndTime;
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
