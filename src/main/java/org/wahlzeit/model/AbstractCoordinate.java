package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{


	@Override
	public double getCartesianDistance(Coordinate c) {
		return this.asCartesianCoordinate().getDistance(c);
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		return this.asSphericCoordinate().getDistance(c);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		
		CartesianCoordinate other = c.asCartesianCoordinate();
		
		if(Double.doubleToLongBits(other.getX()) != Double.doubleToLongBits(this.asCartesianCoordinate().getX()))
			return false;
		if(Double.doubleToLongBits(other.getY()) != Double.doubleToLongBits(this.asCartesianCoordinate().getX()))
			return false;
		if(Double.doubleToLongBits(other.getZ()) != Double.doubleToLongBits(this.asCartesianCoordinate().getX()))
			return false;
		
		return true;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(this.asCartesianCoordinate().getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.asCartesianCoordinate().getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.asCartesianCoordinate().getZ());
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

}
