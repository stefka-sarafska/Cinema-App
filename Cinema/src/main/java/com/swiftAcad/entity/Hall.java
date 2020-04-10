package com.swiftAcad.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hall", schema = "movie")
public class Hall {
	@Id
	private String name;
	@ElementCollection
	private List<String> seats = new ArrayList<>();

    
	@OneToMany(
	        mappedBy = "hall",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Projection> projection;
	
	@ManyToOne
	@JoinColumn(name = "cinema_name")
	@JsonIgnoreProperties("halls")
	private Cinema cinema;
	
	

	public Hall() {
		super();
		// TODO Auto-generated constructor stub
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
		this.seats = seats;
	}



	public List<Projection> getProjection() {
		return projection;
	}



	public void setProjection(List<Projection> projection) {
		this.projection = projection;
	}



	public Cinema getCinema() {
		return cinema;
	}



	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}


}
