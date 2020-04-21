package com.swiftAcad.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.swiftAcad.entity.Projection;
import com.swiftAcad.rest.ProjectionController;
import com.swiftAcad.service.ProjectionService;

public class ProjectionTest {

	@Test
	public void isProjectionDateAfterCurrentDate() {
		Projection projection = new Projection();
		projection.setProjectionDate(LocalDateTime.now().plusHours(1));
		assertTrue(ProjectionService.validateProjectionDate(projection));
	}

	@Test
	public void isProjectionDateEqualsCurrentDate() {
		Projection projection = new Projection();
		projection.setProjectionDate(LocalDateTime.now());
		assertTrue(ProjectionService.validateProjectionDate(projection));
	}

	@Test
	public void isProjectionDateBeforeCurrentDate() {
		Projection projection = new Projection();
		projection.setProjectionDate(LocalDateTime.now().minusDays(1));
		assertFalse(ProjectionService.validateProjectionDate(projection));
	}

	public void isProjectionDeleted() {
		ProjectionController projectionController=new ProjectionController();
		
	}
}
