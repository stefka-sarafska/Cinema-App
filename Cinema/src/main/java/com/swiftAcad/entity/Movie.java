package com.swiftAcad.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movie", schema = "cinema")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Movie {
	@Id
	private String name;
	@Column
	private LocalDateTime premiereDate;
	private String description;
	private String format;
	private String genre;
	private String actors;

	
	@OneToMany(
	        mappedBy = "movie",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Projection> projections;

	

	public Movie() {
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public LocalDateTime getPremiereDate() {
		return premiereDate;
	}



	public void setPremiereDate(LocalDateTime premiereDate) {
		this.premiereDate = premiereDate;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getFormat() {
		return format;
	}



	public void setFormat(String format) {
		this.format = format;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getActors() {
		return actors;
	}



	public void setActors(String actors) {
		this.actors = actors;
	}



	public List<Projection> getProjections() {
		return projections;
	}



	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	

	

}
