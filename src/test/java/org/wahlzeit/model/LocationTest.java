package org.wahlzeit.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class LocationTest {

	private Location l;
	
	@Before
	public void setUp() {
		l = new Location();
	}
	
	@Test
	public void coordinatesExistAndSetToOrigin() {
		Coordinate c = new Coordinate(0,0,0);
		assertTrue(c.isEqual(l.getCoordinates()));
	}
	
}
