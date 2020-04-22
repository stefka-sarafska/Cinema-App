package com.swiftAcad.tests.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.swiftAcad.entity.Contact;
import com.swiftAcad.rest.ContactController;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerIntegrationTest {
	@Autowired
	private ContactController con;

	@Test
	public void givenContact_whenDeleteContact_thenReturnString() {
		Contact contact = new Contact("grand@abv.bg", "Sofia", "0892321455");
		ResponseEntity<String> result=con.deleteContactByEmail(contact.getEmail());
		assertThat(result,is(equalTo("Contact was deleted successfully.")));
	}

}
