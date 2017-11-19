package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {

	private double latitude,longitude,radius;
	
	private final static double rEarth = 6371.0;
	
	public SphericCoordinate() {
		this(0,0,0);
	}
	public SphericCoordinate(double latitude, double longitude) {
		this(latitude,longitude,rEarth);
		
	}
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius; 
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		
		if( radius == 0 ) {
			return new CartesianCoordinate();
		}
		
		double x = radius * Math.sin(longitude) * Math.cos(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(longitude);
		
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		return c.asCartesianCoordinate().getDistance(this.asCartesianCoordinate());
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		return c.asSphericCoordinate().getDistance(this);
	}

	@Override
	public double getDistance(Coordinate c) {
		return doGetSphericalDistance(c.asSphericCoordinate());
	}
	/**
	 * @return Great Circle Distance between two spherical coordinates assuming
	 * a fixed radius (spherical Earth, r=6371km.
	 */
	private double doGetSphericalDistance(SphericCoordinate c) {
		
		double angle = Math.acos(Math.sin(latitude) * Math.sin(c.latitude)+
				Math.cos(latitude)*Math.cos(c.latitude)+Math.cos(Math.abs(longitude)-c.longitude));		
		
		return rEarth*angle;
	}
	@Override
	public boolean isEqual(Coordinate c) {
		
		CartesianCoordinate other = c.asCartesianCoordinate();
		CartesianCoordinate coord = this.asCartesianCoordinate();
		

		if(Double.doubleToLongBits(other.getX()) != Double.doubleToLongBits(coord.getX()))
			return false;
		if(Double.doubleToLongBits(other.getY()) != Double.doubleToLongBits(coord.getY()))
			return false;
		if(Double.doubleToLongBits(other.getZ()) != Double.doubleToLongBits(coord.getZ()))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return isEqual(other);
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
