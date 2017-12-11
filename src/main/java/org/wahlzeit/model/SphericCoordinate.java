package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	private final double latitude,longitude,radius;
	
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
		
		assertClassInvariants();
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		
		CartesianCoordinate c;
		
		assertClassInvariants();
		
		if( radius == 0 ) {
			c = new CartesianCoordinate();
			
			assertIsNotNull(c);
			assertClassInvariants();
			return c;
		}
		
		double x = radius * Math.sin(longitude) * Math.cos(latitude);
		double y = radius * Math.sin(longitude) * Math.sin(latitude);
		double z = radius * Math.cos(longitude);
		
		c = new CartesianCoordinate(x,y,z);
		
		assertIsNotNull(c);
		assertClassInvariants();
		return c;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
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
	
	public double getLatitude() {
		return latitude;
	}
	public SphericCoordinate setLatitude(double latitude) {
		return new SphericCoordinate(latitude, this.longitude,this.radius);
	}
	public double getLongitude() {
		return longitude;
	}
	public SphericCoordinate setLongitude(double longitude) {
		return new SphericCoordinate(this.latitude,longitude,this.radius);
	}
	public double getRadius() {
		return radius;
	}
	public SphericCoordinate setRadius(double radius) {
		return new SphericCoordinate(this.latitude,this.longitude,radius);
	}
	@Override
	protected void assertClassInvariants() {
		assert !Double.isNaN(radius);
		assert !Double.isNaN(latitude);
		assert !Double.isNaN(longitude);
		
		assert latitude >= -90;
		assert latitude <= 90;
		
		assert longitude >= -180;
		assert longitude <= 180;
	}
	
}
