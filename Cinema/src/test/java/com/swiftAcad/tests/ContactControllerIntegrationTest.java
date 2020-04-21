package com.swiftAcad.tests;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.swiftAcad.entity.Contact;
import com.swiftAcad.rest.ContactController;
import com.swiftAcad.service.ContactService;

@RunWith(SpringRunner.class)
@WebMvcTest(ContactController.class)
public class ContactControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ContactService service;

	@Test
	public void givenContact_whenGetContacct_thenReturnJson() {
		Contact contact = new Contact("cinema@gmail.com", "Sofia", "0892321466");

	}

}
