package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MountainsTypeTest {

	
	private MountainsType type;
	private Mountains mountain;
	private Mountains mountain2;
	
	
	@Before
	public void setUp() {
		type = new MountainsType("Mount Everest",8848,"Himalayas","Nepal");
		mountain = new Mountains(type);
		mountain2 = new Mountains(type);
	}
	
	@Test
	public void testMountainCreation() {
		assertNotNull(mountain);
		assertEquals(mountain, mountain2);
	}
}
