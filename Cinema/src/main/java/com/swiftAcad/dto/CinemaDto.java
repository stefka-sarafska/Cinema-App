package com.swiftAcad.dto;

import java.util.ArrayList;
import java.util.List;


public class CinemaDto {
	private String cinemaName;
	private String email;
	private String address;
	private String phone;
	private List<String> halls = new ArrayList<String>();
	private List<String> projections = new ArrayList<String>();

	public CinemaDto(String cinemaName, String email, String address, String phone, String halls, String projections) {
		super();
		this.cinemaName = cinemaName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.halls.add(halls);
		this.projections.add(projections);
		
	}
	


	public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<String> getHalls() {
		return halls;
	}

	public void setHalls(List<String> halls) {
		this.halls = halls;
	}

	public List<String> getProjections() {
		return projections;
	}

	public void setProjections(List<String> projections) {
		this.projections = projections;
	}

	@Override
	public String toString() {
		return "CinemaDto [cinemaName=" + cinemaName + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ ", halls=" + halls + ", projections=" + projections + "]";
	}

	public static List<CinemaDto> compareTo(CinemaDto o, CinemaDto a) {
		List<CinemaDto> cinemas = new ArrayList<CinemaDto>();
		if (o.getCinemaName().equals(a.getCinemaName()) && o.getEmail().equals(a.getEmail())
				&& o.getAddress().equals(a.getAddress()) && o.getPhone().equals(a.getPhone())) {
			o.getHalls().forEach(h -> {
				if (!a.getHalls().contains(h)) {
					a.getHalls().add(h);
				}
				;
			});
			o.getProjections().forEach(p -> {
				if (!a.getProjections().contains(p)) {
					a.getProjections().add(p);
				}
			});
			cinemas.add(a);
		} else {
			cinemas.add(o);
			cinemas.add(a);
		}
		return cinemas;
	}

}
