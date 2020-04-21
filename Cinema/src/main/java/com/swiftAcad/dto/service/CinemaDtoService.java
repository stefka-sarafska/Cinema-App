package com.swiftAcad.dto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftAcad.dto.CinemaDto;
import com.swiftAcad.dto.respository.CinemaDtoRespository;

@Service
public class CinemaDtoService {

	@Autowired
	private CinemaDtoRespository cinemaDtoRespository;

	public Set<CinemaDto> findCinemaData() {
		List<CinemaDto> findedCinemas = new ArrayList<CinemaDto>();
		List<CinemaDto> cinemas = cinemaDtoRespository.fetchCinemaData();

		if (!cinemas.isEmpty()) {
			for (int i = 1; i < cinemas.size(); i++) {
				CinemaDto currCinema = cinemas.get(i);
				CinemaDto prevCinema = cinemas.get(i - 1);
				List<CinemaDto> currCinemas = CinemaDto.compareTo(prevCinema, currCinema);
				findedCinemas.addAll(currCinemas);
			}
		}
		if (cinemas.size() == 1) {
			findedCinemas.addAll(cinemas);
		}
		return new HashSet<>(findedCinemas);
	}

}
