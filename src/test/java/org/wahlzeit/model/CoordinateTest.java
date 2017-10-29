package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	private Coordinate c1,c2,c3;
	
	@Before
	public void setUp() {
		this.c1 = new Coordinate();
		this.c2 = new Coordinate(0,0,1.0);
		this.c3 = new Coordinate(0,0,0.999999);
	}
	
	@Test
	public void isEqualTest() {
		assertTrue("Coordinates should be equal to themselves.",c2.isEqual(c2));
		assertTrue("[0,0,1.0] should be equal to [0,0,1]",c2.isEqual(new Coordinate(0,0,1)));
		assertFalse("Coordinates [0,0,0] and [0,0,1] should not be equal",c1.isEqual(c2)); 
		assertFalse("Coordinates [0,0,0.999999] and [0,0,1] should not be equal",c1.isEqual(c3));
	}
	
	@Test
	public void distanceTest() {
		double d1 = c2.getDistance(c2);
		double d2 = c2.getDistance(c1);
		double d3 = c2.getDistance(new Coordinate(2,0,1));
		double d4 = c2.getDistance(new Coordinate(-2,0.0,1));
		
		assertEquals(0, d1, "Distance of the same coordinates should be zero");
		assertEquals(1, d2);
		assertEquals(2,d3);
		assertEquals(d3,d4);
	}
	
}
