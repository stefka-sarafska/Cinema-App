package com.swiftAcad.tests.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.swiftAcad.entity.Cinema;
import com.swiftAcad.entity.Contact;
import com.swiftAcad.entity.Hall;
import com.swiftAcad.rest.CinemaController;
import com.swiftAcad.service.CinemaService;

@RunWith(SpringRunner.class)
@WebMvcTest(CinemaController.class)
public class CinemaControllerIntegrationTest {

	@Mock
	private CinemaService service;
	@MockBean
	private MockMvc mvc;

	@Test
	public void givenCinema_whenGetCinema_thenReturnJson() throws Exception {
		List<Hall> halls = new ArrayList<Hall>();
		halls.add(new Hall("king","1 2 3"));
		Contact contact = new Contact("grand@abv.bg", "Sofia", "0892321455");
		Cinema cinema = new Cinema("Grand", contact, halls);
		
		when(service.findCinemaByName(cinema.getName())).thenReturn(cinema);
		mvc.perform(get("/api/cinema/"+cinema.getName())).andExpect(status().is2xxSuccessful());
	}
}
