package com.swiftAcad.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import com.swiftAcad.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{

	public Contact findByEmail(String email);
	@Transactional
	@Modifying
	public void deleteByEmail(String email);

}
