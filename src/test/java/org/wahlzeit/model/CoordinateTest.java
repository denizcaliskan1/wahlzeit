package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {

	private CartesianCoordinate c1;
	private CartesianCoordinate c2;
	
	private SphericCoordinate cs1;
	private SphericCoordinate cs2;
	
	@Before
	public void setUp() {
		this.c1 = new CartesianCoordinate(0,0,1);
		this.c2 = new CartesianCoordinate(2,0,1);
		
		this.cs1 = new SphericCoordinate();
		this.cs2 = new SphericCoordinate(1,1);
	}
	
	@Test
	public void testConversionSphericToCartesian(){
		
		
		SphericCoordinate cs = c1.asSphericCoordinate();
		
		assertTrue(c1.isEqual(cs));
		assertTrue(cs.isEqual(c1));
		
		assertTrue(cs.asCartesianCoordinate().isEqual(c1));
	}
	
	@Test
	public void testCartesianDistance() {
		assertEquals(2,c1.getCartesianDistance(c2));
	}
	
	@Test
	public void testSphericalDistance() {
		
		assertEquals(cs1.getSphericDistance(cs2),cs2.getSphericDistance(cs1));
		
	}
}
