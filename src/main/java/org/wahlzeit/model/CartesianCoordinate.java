package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

	private final double x,y,z;
	
	public CartesianCoordinate() {
		this(0,0,0);
	}
	public CartesianCoordinate( double x, double y) {
		this(x,y,0);
	}
	public CartesianCoordinate(double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		assertClassInvariants();
	}
		
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		
		assertClassInvariants();
		
		SphericCoordinate c;
		
		double radius = Math.sqrt(x*x + y*y + z*z);
		
		if(radius == 0) {
			c = new SphericCoordinate();
			
			assertIsNotNull(c);
			assertClassInvariants();
			return c;
		}
		
		double latitude = Math.atan2(y, x);
		double longitude = Math.acos(z/radius);
		
		assertNotOverflowed(latitude);
		assertNotOverflowed(longitude);
		
		c = new SphericCoordinate(latitude,longitude,radius);
		
		assertIsNotNull(c);
		assertClassInvariants();
		return c;
	}

	@Override
	public double getDistance(Coordinate c) {
		return doGetDistance(c.asCartesianCoordinate());
	}

	private double doGetDistance(CartesianCoordinate c) {
		
		double dx = Math.pow(x-c.x, 2);
		double dy = Math.pow(y-c.y, 2);
		double dz = Math.pow(z-c.z, 2);
		
		return Math.sqrt(dx+dy+dz);
	}
	
	public double getX() {
		return x;
	}
	public CartesianCoordinate setX(double x) {
		return new CartesianCoordinate(x, this.y,this.z);
	}
	public double getY() {
		return y;
	}
	public CartesianCoordinate setY(double y) {
		return new CartesianCoordinate(this.x,y,this.z);
	}
	public double getZ() {
		return z;
	}
	public CartesianCoordinate setZ(double z) {
		return new CartesianCoordinate(this.x,this.y,z);
	}
	
	@Override
	protected void assertClassInvariants() {
		assert !Double.isNaN(x);
		assert !Double.isNaN(y);
		assert !Double.isNaN(z);
	}
}
