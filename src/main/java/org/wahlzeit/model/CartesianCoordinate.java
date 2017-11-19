package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {

	private double x,y,z;
	
	public CartesianCoordinate() {
		this(0,0,0);
	}
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		return c.asCartesianCoordinate().getDistance(this);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		
		double radius = Math.sqrt(x*x + y*y + z*z);
		
		if(radius == 0)return new SphericCoordinate();
		
		double latitude = Math.atan2(y, x);
		double longitude = Math.acos(z/radius);
		
		return new SphericCoordinate(latitude,longitude,radius);
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		return this.getDistance(c.asCartesianCoordinate());
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
	
	@Override
	public boolean isEqual(Coordinate c) {
		
		CartesianCoordinate other = c.asCartesianCoordinate();
		
		if(Double.doubleToLongBits(other.x) != Double.doubleToLongBits(x))return false;
		if(Double.doubleToLongBits(other.y) != Double.doubleToLongBits(y))return false;
		if(Double.doubleToLongBits(other.z) != Double.doubleToLongBits(z))return false;
		
		return true;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
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
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}

	
}
