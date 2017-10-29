package org.wahlzeit.model;

public class Coordinate {

	private double x;
	private double y;
	private double z;
	
	public Coordinate() {
		this(0,0,0);
	}
	
	
	public Coordinate(double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getDistance( Coordinate c ) {
		
		double dx2 = Math.pow(x-c.x,2);
		double dy2 = Math.pow(y-c.y,2);
		double dz2 = Math.pow(z-c.z,2);
		
		return Math.sqrt(dx2+dy2+dz2);
		
	}
	
	public boolean isEqual(Coordinate c) { 
		
		if (this == c)
			return true;
		if (c == null)
			return false;
		
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(c.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(c.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(c.z))
			return false;
		
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass() != obj.getClass())
			return false;
		return(isEqual((Coordinate) obj));
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
