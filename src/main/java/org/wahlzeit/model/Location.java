package org.wahlzeit.model;

public class Location {

	private Coordinate coordinates;

	public Location() {
		this(new Coordinate());
	}

	public Location(Coordinate coordinates) {
		this.coordinates = coordinates;
	}
	

	public Coordinate getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinate coordinates) {
		this.coordinates = coordinates;
	}
	
	public void setCoordinates( double x, double y, double z) {
		this.coordinates.setX(x);
		this.coordinates.setY(y);
		this.coordinates.setZ(z);
	}
}
