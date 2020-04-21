package com.swiftAcad.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cinema", schema = "cinema")
public class Cinema {
	@Id
	private String name;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_email", referencedColumnName = "email")
	@JsonIgnoreProperties("cinema")
	private Contact contact;

	@OneToMany(mappedBy = "cinema")
	@JsonIgnoreProperties("cinema")
	private List<Projection> projections;

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("cinema")
	private List<Hall> halls;

	public Cinema() {
	}

	public Cinema(String name, Contact contact, List<Hall> halls) {
		super();
		this.name = name;
		this.contact = contact;
		this.halls = halls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Projection> getProjections() {
		return projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public List<Hall> getHalls() {
		return halls;
	}

	public void setHalls(List<Hall> halls) {
		this.halls = halls;
	}

}
