package com.swiftAcad.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cinema", schema = "cinema")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Cinema {
	@Id
	private String name;

	@OneToOne(mappedBy = "cinema", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Contact contact;

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Projection> projections;

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Hall> halls;

	public Cinema() {
		super();
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
