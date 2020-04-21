package com.swiftAcad.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieDto {
	private String name;
	private String actors;
	private String description;
	private String format;
	private String genre;
	private LocalDateTime premiereDate;
	private List<LocalDateTime> projections=new ArrayList<LocalDateTime>();

	public MovieDto(String name, String actors, String description, String format, String genre,
			LocalDateTime premiereDate, LocalDateTime projections) {
		super();
		this.name = name;
		this.actors = actors;
		this.description = description;
		this.format = format;
		this.genre = genre;
		this.premiereDate = premiereDate;
		this.projections.add(projections);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
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

	public LocalDateTime getPremiereDate() {
		return premiereDate;
	}

	public void setPremiereDate(LocalDateTime premiereDate) {
		this.premiereDate = premiereDate;
	}

	public List<LocalDateTime> getProjections() {
		return projections;
	}

	public void setProjections(List<LocalDateTime> projections) {
		this.projections = projections;
	}

	@Override
	public String toString() {
		return "MovieDto [name=" + name + ", actors=" + actors + ", description=" + description + ", format=" + format
				+ ", genre=" + genre + ", premiereDate=" + premiereDate + "]";
	}
	
	public static List<MovieDto> compareTo(MovieDto o, MovieDto a) {
		List<MovieDto> movies = new ArrayList<>();
		if (o.toString().equals(a.toString())) {
			o.getProjections().forEach(p -> {
				if (!a.getProjections().contains(p)) {
					a.getProjections().add(p);
				}
				;
			});
			
			movies.add(a);
		} else {
			movies.add(o);
			movies.add(a);
		}
		return movies;
	}

}
