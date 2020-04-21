package com.swiftAcad.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.swiftAcad.entity.Contact;
import com.swiftAcad.service.ContactService;

public class ContactTest {

	@Test
	public void isContactEmailValid() {
		Contact contact = new Contact();
		contact.setEmail("cinema@abv.bg");
		boolean isValid = ContactService.isValidEmail(contact.getEmail());
		assertTrue(isValid);
	}

	@Test
	public void isContactEmailInvalid() {
		Contact contact = new Contact();
		contact.setEmail("cin@ema@abv.bg");
		boolean isValid = ContactService.isValidEmail(contact.getEmail());
		assertFalse(isValid);
	}

	@Test
	public void testPhoneNumberStartingWith0() {
		Contact contact = new Contact();
		contact.setPhone("089 232 1455");
		boolean isValid = ContactService.isValidPhoneNumber(contact.getPhone());
		assertTrue(isValid);
	}

	@Test
	public void testPhoneNumberStartingWith359() {
		Contact contact = new Contact();
		contact.setPhone("+35989 232 1455");
		boolean isValid = ContactService.isValidPhoneNumber(contact.getPhone());
		assertTrue(isValid);
	}

}
