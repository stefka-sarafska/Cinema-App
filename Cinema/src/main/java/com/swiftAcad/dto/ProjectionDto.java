package com.swiftAcad.dto;

import java.time.LocalDateTime;

public class ProjectionDto {
	private long projectionId;
	private String cinemaName;
	private String movieName;
	private String hallName;
	private LocalDateTime projectionDate;

	public ProjectionDto(long projectionId, String cinemaName, String movieName, String hallName,
			LocalDateTime projectionDate) {
		this.projectionId = projectionId;
		this.cinemaName = cinemaName;
		this.movieName = movieName;
		this.hallName = hallName;
		this.projectionDate = projectionDate;
	}

	public long getProjectionId() {
		return projectionId;
	}

	public void setProjectionId(long projectionId) {
		this.projectionId = projectionId;
	}

	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getHallName() {
		return hallName;
	}

	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	public LocalDateTime getProjectionDate() {
		return projectionDate;
	}

	public void setProjectionDate(LocalDateTime projectionDate) {
		this.projectionDate = projectionDate;
	}

}
