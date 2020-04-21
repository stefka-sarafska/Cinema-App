package com.swiftAcad.tests;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.swiftAcad.entity.Cinema;
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
		Cinema cinema = new Cinema("Grand");
		when(service.findCinemaByName("Grand")).thenReturn(cinema);

		mvc.perform(get("/api/cinema/{name}"))
		.andExpect(status().is2xxSuccessful());
	}
}
