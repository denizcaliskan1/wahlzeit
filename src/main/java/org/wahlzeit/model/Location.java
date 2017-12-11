package org.wahlzeit.model;

public class Location {

	private CartesianCoordinate coordinates;

	public Location() {
		this(new CartesianCoordinate());
	}

	public Location(CartesianCoordinate coordinates) {
		
		if( coordinates == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		
		this.coordinates = coordinates;
	}
	

	public Coordinate getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(CartesianCoordinate coordinates) {
		this.coordinates = coordinates;
	}
	
	public void setCoordinates( double x, double y, double z) {
		this.coordinates.setX(x);
		this.coordinates.setY(y);
		this.coordinates.setZ(z);
	}
}
